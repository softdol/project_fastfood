package manager.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Category;
import database.manager.Menu;
import database.manager.ReturnModel;
import database.manager.SubCategory;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.ImgUpActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;
import manager.component.ManagerCP;
import manager.component.TextFieldSub;

public class MenuModify extends JPanel {

	public JLabel lblImg;
	public JTextField txtImgPath;
	ManagerMain main;
	
	public MenuModify(ManagerMain main, int idx) {
		this.main = main;
		
		setLayout(null);
		setBounds(0,0,565,730);
		setBorder(new LineBorder(Color.BLACK));
		LabelTitle lblTitle = new LabelTitle("��ǰ ����");
		
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu where menu_idx = ?";
		psList.add(new PsList('I', String.valueOf(idx)));
		
		Menu menuInfo = ReturnModel.selMenu(sql, psList);
		
		if(menuInfo == null) {
			System.out.println("��ǰ ������ �����ϴ�.");
			//main.viewPanel("��Ʈ�޴����");
			return;
		}
		
		ArrayList<Category> cataList = ReturnModel.categoryList();

		JComboBox cateList = new JComboBox();
		cateList.addItem("--��з�--");		
		for(int i = 0; i < cataList.size(); i++) {
			cateList.addItem(cataList.get(i).getMenu_category_name());			
			if(cataList.get(i).getMenu_category_idx() == menuInfo.getMenu_category()) {
				cateList.setSelectedIndex(i + 1);
			}
		}
		
		cateList.setBounds(lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20 , 80, 50);
		cateList.setFont(new Font("���ü", Font.BOLD, 14));
		
		JComboBox cateSubList = new JComboBox();
		
		ArrayList<SubCategory> subCateList = ReturnModel.categorySubList();
		cateSubList.addItem("--�ߺз�--");
		for(int i = 0; i < subCateList.size(); i++) {
			cateSubList.addItem(subCateList.get(i).getMenu_subcategory_name());			
			if(subCateList.get(i).getMenu_subcategory_idx() == menuInfo.getMenu_subcategory_idx()) {
				cateSubList.setSelectedIndex(i + 1);
			}
		}
		
		cateSubList.setBounds(cateList.getX() + cateList.getWidth() + 20, cateList.getY() , 80, 50);
		cateSubList.setFont(new Font("���ü", Font.BOLD, 14));
		
		
		LabelSub lblName = new LabelSub("�޴���", cateList.getX(), cateList.getY() + cateList.getHeight() + 20);
		LabelSub lblPrice = new LabelSub("����", lblName.getX(), lblName.getY() + lblName.getHeight() + 20);
		LabelSub lblSale = new LabelSub("������", lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20);
		
		TextFieldSub txtName = new TextFieldSub(menuInfo.getMenu_name(), lblName.getX() + lblName.getWidth() + 10, lblName.getY());
		TextFieldSub txtPrice = new TextFieldSub(String.valueOf(menuInfo.getMenu_price()), lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY());
		TextFieldSub txtSale = new TextFieldSub(String.valueOf(menuInfo.getMenu_sale()), lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY());
		
		lblImg = new JLabel(new ImageIcon(ManagerCP.imgResize(menuInfo.getImg_big_path(),80,160)));
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, cateList.getY() , 180, 200);
		
		JButton btnImg = new JButton("�̹��� ã��");
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(this));
		
		JButton btnInsert = new JButton("����");
		btnInsert.setFont(new Font("���ü", Font.BOLD, 14));
		btnInsert.setBounds(txtSale.getX() - 30, btnImg.getY() + btnImg.getHeight() + 40 , 80, 40);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean inputChk = true;
				
				if(cateList.getSelectedIndex() == 0) {					
					ManagerCP.viewError("��з��� ������ �ּ���.","�Է¿���");					
					cateList.requestFocus();
					inputChk = false;
					return;
				}
				if(cateSubList.getSelectedIndex() == 0) {					
					ManagerCP.viewError("�ߺз��� ������ �ּ���.","�Է¿���");					
					cateSubList.requestFocus();
					inputChk = false;
					return;
				}
				if(txtName.getText().trim().length() == 0) {					
					ManagerCP.viewError("�޴����� �Է��� �ּ���.","�Է¿���");
					txtName.requestFocus();
					inputChk = false;
					return;
				}
				if(txtPrice.getText().trim().length() == 0) {
					ManagerCP.viewError("������ �Է��� �ּ���.","�Է¿���");
					txtPrice.requestFocus();
					inputChk = false;
					return;
				}
				if(txtSale.getText().trim().length() == 0) {
					ManagerCP.viewError("�������� �Է��� �ּ���.","�Է¿���");
					txtSale.requestFocus();
					inputChk = false;
					return;
				}
				
				if(!main.mInfo.getLogin()) {
					ManagerCP.viewError("����� ������ �����ϴ�.","�α��� ����");
					inputChk = false;
					return;
				}				
				
				if(inputChk) {
					ArrayList<PsList> psList = new ArrayList<>();
					psList.add(new PsList('I', String.valueOf(cataList.get(cateList.getSelectedIndex() - 1).getMenu_category_idx())));
					
					String[] fileName = txtImgPath.getText().split("\\.");
					String fileExt = "";
					String filePath = "imgUpload";
					if(fileName.length > 1) {
						fileExt = System.currentTimeMillis() + "." + fileName[1];
						ManagerCP.fileSave(new File(txtImgPath.getText()), filePath,fileExt);
						File delFile = new File(menuInfo.getImg_big_path());
						
						if(delFile.exists()) {
							delFile.delete();
						}
						
						psList.add(new PsList('S',filePath + "\\" + fileExt));
					}else {
						psList.add(new PsList('S',menuInfo.getImg_big_path()));
					}
					
					psList.add(new PsList('S',txtName.getText()));
					psList.add(new PsList('I',txtPrice.getText()));
					psList.add(new PsList('I',txtSale.getText()));
					psList.add(new PsList('S',main.mInfo.getMember_id()));
					psList.add(new PsList('I', String.valueOf(subCateList.get(cateSubList.getSelectedIndex() - 1).getMenu_subcategory_idx())));
					psList.add(new PsList('I',String.valueOf(menuInfo.getMenu_idx())));
					
					String sqi_menuUpt = "update menu";
					sqi_menuUpt += " set MENU_CATEGORY_IDX = ?";
					sqi_menuUpt += " , IMG_BIG_PATH = ?";
					sqi_menuUpt += " , MENU_NAME = ?";
					sqi_menuUpt += " , MENU_PRICE = ?";
					sqi_menuUpt += " , MENU_SALE = ?";
					sqi_menuUpt += " , MENU_MOD_DATE = sysdate";
					sqi_menuUpt += " , MENU_MOD_ID = ?";
					sqi_menuUpt += " , MENU_SUBCATEGORY_IDX = ?";
					sqi_menuUpt += " where MENU_IDX = ?";
					
//					System.out.println(sqi_menuUpt);
//					
//					for(PsList p : psList) {
//						System.out.println(p.getType() + " : " + p.getVal());
//					}

					if(OjdbcConnection.insert(sqi_menuUpt, psList)) {
						ManagerCP.viewSuccess("��ǰ�� ���� �Ǿ����ϴ�.","��ǰ���");
						main.viewPanel("��ǰ���");
					}else{
						ManagerCP.viewError("��ǰ ��Ͽ� �����߽��ϴ�.","����");
					};
				}
			}
		});
		
		JButton btnSetList = new JButton("��� ����");
		btnSetList.setFont(new Font("���ü", Font.BOLD, 14));
		btnSetList.setBounds(btnInsert.getX() + btnInsert.getWidth() + 20, btnInsert.getY() , 120, 40);
		btnSetList.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				main.viewPanel("��ǰ���");
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		add(lblTitle);
		add(cateList);
		add(cateSubList);
		
		add(lblName);
		add(lblPrice);
		add(lblSale);
		
		add(txtName);
		add(txtPrice);
		add(txtSale);
		
		add(btnImg);
		add(lblImg);
		add(txtImgPath);
		
		add(btnInsert);
		add(btnSetList);
	}
}

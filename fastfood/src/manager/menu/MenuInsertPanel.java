package manager.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import database.manager.ReturnModel;
import database.model.PsList;
import manager.actionlistener.ImgUpActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;
import manager.component.ManagerCP;
import manager.component.TextFieldSub;

public class MenuInsertPanel extends JPanel {
	
	public JLabel lblImg;
	public JTextField txtImgPath;
	private MenuMainPanel menuMain;
	
	public MenuInsertPanel(MenuMainPanel menuMain) {
		
		this.menuMain = menuMain;
		
		setLayout(null);
		setBounds(0,0,565,730);
		setBorder(new LineBorder(Color.BLACK));
		LabelTitle lblTitle = new LabelTitle("��ǰ ���");
		
		String sql = "select * from menu_catagory";
		ArrayList<Category> cataList = ReturnModel.catagoryList(sql);

		JComboBox cateList = new JComboBox();
		cateList.addItem("--��з�--");
		for(Category c : cataList) {
			cateList.addItem(c.getMenu_category_name());
		}
		
		cateList.setBounds(lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20 , 80, 50);
		cateList.setFont(new Font("���ü", Font.BOLD, 14));
		
		LabelSub lblName = new LabelSub("�޴���", cateList.getX(), cateList.getY() + cateList.getHeight() + 20);
		LabelSub lblPrice = new LabelSub("����", lblName.getX(), lblName.getY() + lblName.getHeight() + 20);
		LabelSub lblSale = new LabelSub("������", lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20);
		
		TextFieldSub txtName = new TextFieldSub("", lblName.getX() + lblName.getWidth() + 10, lblName.getY());
		TextFieldSub txtPrice = new TextFieldSub("", lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY());
		TextFieldSub txtSale = new TextFieldSub("0", lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY());
		
		lblImg = new JLabel("   �̹���");
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, cateList.getY() , 180, 200);
		
		JButton btnImg = new JButton("�̹��� ã��");
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(menuMain));
		
		JButton btnInsert = new JButton("���");
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
				if(txtImgPath.getText().trim().length() == 0) {
					ManagerCP.viewError("�̹����� �Է� ���� �ʾҽ��ϴ�.","�Է¿���");
					inputChk = false;
					return;
				}
				if(!menuMain.mInfo.getLogin()) {
					ManagerCP.viewError("����� ������ �����ϴ�.","�α��� ����");
					inputChk = false;
					return;
				}
				
				if(inputChk) {				
					String sql = "iinsert into menu values(menu_idx_seq.nextval, ";
							sql += " ?, ?, ?, ?, ?, 'Y', sysdate, ?)";
					ArrayList<PsList> psList = new ArrayList<>();
					psList.add(new PsList('I', String.valueOf(cataList.get(cateList.getSelectedIndex() - 1).getMenu_category_idx())));
					
					String[] fileName = txtImgPath.getText().split("\\.");
					String fileExt = "";
					String filePath = "imgUpload";
					if(fileName.length > 1) {
						fileExt = System.currentTimeMillis() + "." + fileName[1];
						ManagerCP.fileSave(new File(txtImgPath.getText()), filePath,fileExt);
					}
					
					psList.add(new PsList('S',filePath + "\\" + fileExt));
					psList.add(new PsList('S',txtName.getText()));
					psList.add(new PsList('I',txtPrice.getText()));
					psList.add(new PsList('I',txtSale.getText()));
					psList.add(new PsList('S',menuMain.mInfo.getMember_id()));
					
					String sqi_menuIns = "insert into menu (MENU_IDX, MENU_CATEGORY_IDX, IMG_BIG_PATH, MENU_NAME, MENU_PRICE, MENU_SALE, MENU_USE_FLAG, MENU_IN_DATE, MENU_IN_ID ) ";
						   sqi_menuIns += "values(MENU_IDX_SEQ.nextval, ?, ?, ?, ?, ?, 'Y', sysdate, ?)";
					if(OjdbcConnection.insert(sqi_menuIns, psList)) {
						ManagerCP.viewSuccess("��ǰ�� ��� �Ǿ����ϴ�.","��ǰ���");
						cateList.setSelectedIndex(0);
						txtName.setText("");
						txtPrice.setText("");
						txtSale.setText("0");
						txtImgPath.setText("");
						lblImg.setIcon(null);
					}else{
						ManagerCP.viewError("��ǰ ��Ͽ� �����߽��ϴ�.","����");
					};
					
//					for(PsList p : psList) {
//						System.out.println(p.getType() + " : " + p.getVal());
//					}
				}
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		add(lblTitle);
		add(cateList);
		
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
		
	}
	
//	public void viewUpImg(String path) {
//		ImageIcon icon = new ImageIcon(path);
//		txtImgPath.setText(path);
//		
//		Image img = icon.getImage();
//		System.out.println("img path : " + txtImgPath.getText());
//		Image cimg = img.getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),img.SCALE_SMOOTH);		
//		lblImg.setIcon(new ImageIcon(cimg));
//	}

}

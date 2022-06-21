package manager.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.MenuSet;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.ImgUpActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;
import manager.component.ManagerCP;
import manager.component.TextFieldSub;

public class MenuSetModify extends JPanel {

	public JLabel lblImg;
	public JTextField txtImgPath;
	ManagerMain main;
	
	public MenuSetModify(ManagerMain main, int idx) {
		this.main = main;
		
		setLayout(null);
		setBounds(0,0,565,730);
		setBorder(new LineBorder(Color.BLACK));
		
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu_set where set_idx = ?";
		psList.add(new PsList('I', String.valueOf(idx)));
		
		MenuSet menuInfo = ReturnModel.selMenuSet(sql, psList);
		
		if(menuInfo == null) {
			System.out.println("세트 정보가 없습니다.");
			//main.viewPanel("세트메뉴목록");
			return;
		}
		
		LabelTitle lblTitle = new LabelTitle("세트 상품 수정");
	
		LabelSub lblName = new LabelSub("메뉴명", lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20);
		LabelSub lblPrice = new LabelSub("가격", lblName.getX(), lblName.getY() + lblName.getHeight() + 20);
		LabelSub lblSale = new LabelSub("할인율", lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20);
		
		TextFieldSub txtName = new TextFieldSub(menuInfo.getSet_name(), lblName.getX() + lblName.getWidth() + 10, lblName.getY());
		TextFieldSub txtPrice = new TextFieldSub(String.valueOf(menuInfo.getSet_price()), lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY());
		TextFieldSub txtSale = new TextFieldSub(String.valueOf(menuInfo.getSet_sale()), lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY());
		
		lblImg = new JLabel(new ImageIcon(ManagerCP.imgResize(menuInfo.getSet_img_path(),180,160)));
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, txtName.getY() , 180, 160);
		
		//lblImg.pic
		
		JButton btnImg = new JButton("이미지 찾기");
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(this));
		
		JButton btnInsert = new JButton("수정");
		btnInsert.setFont(new Font("고딕체", Font.BOLD, 14));
		btnInsert.setBounds(txtSale.getX() - 30, btnImg.getY() + btnImg.getHeight() + 40 , 80, 40);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean inputChk = true;
				
				if(txtName.getText().trim().length() == 0) {					
					ManagerCP.viewError("메뉴명을 입력해 주세요.","입력오류");
					txtName.requestFocus();
					inputChk = false;
					return;
				}
				if(txtPrice.getText().trim().length() == 0) {
					ManagerCP.viewError("가격을 입력해 주세요.","입력오류");
					txtPrice.requestFocus();
					inputChk = false;
					return;
				}
				if(txtSale.getText().trim().length() == 0) {
					ManagerCP.viewError("할인율을 입력해 주세요.","입력오류");
					txtSale.requestFocus();
					inputChk = false;
					return;
				}
				
				if(!main.mInfo.getLogin()) {
					ManagerCP.viewError("담당자 정보가 없습니다.","로그인 오류");
					inputChk = false;
					return;
				}
				
				if(inputChk) {
					ArrayList<PsList> psList = new ArrayList<>();
					
					String[] fileName = txtImgPath.getText().split("\\.");
					String fileExt = "";
					String filePath = "imgSetUpload";
					
					if(fileName.length > 1) {
						fileExt = System.currentTimeMillis() + "." + fileName[1];
						ManagerCP.fileSave(new File(txtImgPath.getText()), filePath,fileExt);
						
						File delFile = new File(menuInfo.getSet_img_path());
						
						if(delFile.exists()) {
							delFile.delete();
						}
						
						psList.add(new PsList('S',filePath + "\\" + fileExt));
					}else {
						psList.add(new PsList('S',menuInfo.getSet_img_path()));
					}
					
					psList.add(new PsList('S',txtName.getText()));
					psList.add(new PsList('I',txtPrice.getText()));
					psList.add(new PsList('I',txtSale.getText()));
					psList.add(new PsList('S',main.mInfo.getMember_id()));
					psList.add(new PsList('I',String.valueOf(menuInfo.getSet_idx())));
					
					String sqi_menuUpt = "update menu_set";
							sqi_menuUpt += " set SET_IMG_PATH = ?";
							sqi_menuUpt += " ,SET_NAME = ?";
							sqi_menuUpt += " ,SET_PRICE = ?";
							sqi_menuUpt += " ,SET_SALE = ?";
							sqi_menuUpt += " ,SET_MOD_DATE = sysdate";
							sqi_menuUpt += " ,SET_MOD_ID = ?";
							sqi_menuUpt += " where SET_IDX = ?";
		
					if(OjdbcConnection.insert(sqi_menuUpt, psList)) {
						ManagerCP.viewSuccess("상품이 수정 되었습니다.","상품수정");
						main.viewPanel("세트메뉴목록");
					}else{
						ManagerCP.viewError("상품 등록에 실패했습니다.","실패");
					};
					
				}
			}
		});
		
		JButton btnSetList = new JButton("목록 보기");
		btnSetList.setFont(new Font("고딕체", Font.BOLD, 14));
		btnSetList.setBounds(btnInsert.getX() + btnInsert.getWidth() + 20, btnInsert.getY() , 120, 40);
		btnSetList.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				main.viewPanel("세트메뉴목록");
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		add(lblTitle);
		
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

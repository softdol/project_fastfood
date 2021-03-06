package manager.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.ImgUpActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;
import manager.component.ManagerCP;
import manager.component.TextFieldSub;

public class MenuSetInsert extends JPanel {
		
	public JLabel lblImg;
	public JTextField txtImgPath;
	ManagerMain main;
	ArrayList<Menu> repList;
		
	public MenuSetInsert(ManagerMain main) {
		this.main = main;
		main.setSize(585,730);
		setLayout(null);	
		setBounds(0,0,565,730);
		setBorder(new LineBorder(Color.BLACK));
		LabelTitle lblTitle = new LabelTitle("세트 상품 등록");
	
		LabelSub lblName = new LabelSub("메뉴명", lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20);
		LabelSub lblPrice = new LabelSub("가격", lblName.getX(), lblName.getY() + lblName.getHeight() + 20);
		LabelSub lblSale = new LabelSub("할인율", lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20);
		LabelSub lblRep = new LabelSub("대표메뉴", lblSale.getX(), lblSale.getY() + lblSale.getHeight() + 20, 100, 40);
		
		TextFieldSub txtName = new TextFieldSub("", lblName.getX() + lblName.getWidth() + 10, lblName.getY());
		TextFieldSub txtPrice = new TextFieldSub("", lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY());
		TextFieldSub txtSale = new TextFieldSub("0", lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY());
		JComboBox cbRep = new JComboBox();
		
		String sqlRep = "select * from menu where MENU_CATEGORY_IDX = ?";
		repList = new ArrayList<>();
		
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('I',"1"));
		
		repList = ReturnModel.selMenuList(sqlRep, psList);
		
		cbRep.setBounds(txtName.getX(),lblRep.getY(),160,40);
		cbRep.addItem("----------대표메뉴----------");
		for(int i = 0; i < repList.size(); i++) {
			cbRep.addItem(repList.get(i).getMenu_name() + "("+ repList.get(i).getMenu_price()  +")");
		}
		
		lblImg = new JLabel("   이미지");
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, txtName.getY() , 180, 160);
		
		JButton btnImg = new JButton("이미지 찾기");
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(this));
		
		JButton btnInsert = new JButton("등록");
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
				if(txtImgPath.getText().trim().length() == 0) {
					ManagerCP.viewError("이미지가 입력 되지 않았습니다.","입력오류");
					inputChk = false;
					return;
				}
				if(cbRep.getSelectedIndex() == 0) {
					ManagerCP.viewError("대표 메뉴를 선택해 주세요.","입력오류");
					cbRep.requestFocus();
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
					}
					
					psList.add(new PsList('S',filePath + "\\" + fileExt));
					psList.add(new PsList('S',txtName.getText()));
					psList.add(new PsList('I',txtPrice.getText()));
					psList.add(new PsList('I',txtSale.getText()));
					psList.add(new PsList('S',main.mInfo.getMember_id()));
					psList.add(new PsList('I',repList.get(cbRep.getSelectedIndex() - 1).getMenu_idx().toString()));
					
					String sqi_menuIns = "insert into menu_set (SET_IDX, SET_IMG_PATH, SET_NAME, SET_PRICE, SET_SALE, SET_USE_FLAG, SET_IN_DATE, SET_IN_ID, MENU_IDX) ";
						   sqi_menuIns += "values(SET_IDX_SEQ.nextval, ?, ?, ?, ?, 'Y', sysdate, ?, ?)";
					if(OjdbcConnection.insert(sqi_menuIns, psList)) {
						ManagerCP.viewSuccess("상품이 등록 되었습니다.","상품등록");
						main.viewPanel("세트메뉴목록");
					}else{
						ManagerCP.viewError("상품 등록에 실패했습니다.","실패");
					};
					
				}
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		add(lblTitle);
		
		add(lblName);
		add(lblPrice);
		add(lblSale);
		add(lblRep);
		
		add(txtName);
		add(txtPrice);
		add(txtSale);
		add(cbRep);
		
		add(btnImg);
		add(lblImg);
		add(txtImgPath);
		
		add(btnInsert);
	}

}

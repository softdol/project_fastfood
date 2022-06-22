package manager.member;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.function.ObjDoubleConsumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Member;
import database.manager.ReturnModel;
import database.manager.Store;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.MemberActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;
import manager.component.ManagerCP;
import manager.component.TextFieldSub;

public class MemberMain extends JPanel {
	
	JPanel jpSetList;
	Store storeInfo;
	
	ManagerMain main;
	ArrayList<Member> setMemberList;
	ArrayList<PsList> psList;
	
	TextFieldSub txtName;
	TextFieldSub txtBNum;
	TextFieldSub txtAdress;
	TextFieldSub txtCeo;
	TextFieldSub txtPhone;
	
	JLabel topBottomNum;
	JTextField topBottoId;
	JTextField topBottoName;
	JPasswordField topBottoPass;
	JButton topBottoEtc;
	
	public MemberMain(ManagerMain main) {
		this.main = main;
		
		setLayout(null);
		setBounds(0,0,565,726);
		setBorder(new LineBorder(Color.BLACK));
		
		LabelTitle lblTitle = new LabelTitle("매장 관리");
		
		add(lblTitle);
		
		LabelSub lblName = new LabelSub("상호", lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20);
		LabelSub lblBNum = new LabelSub("사업자번호", lblName.getX() + 250, lblName.getY(), 80, 40);
		LabelSub lblAdress = new LabelSub("주소", lblTitle.getX(), lblName.getY() + lblName.getHeight());
		LabelSub lblCeo = new LabelSub("대표자", lblTitle.getX(), lblAdress.getY() + lblAdress.getHeight());
		LabelSub lblPhone = new LabelSub("전화번호", lblBNum.getX(), lblCeo.getY(), 80, 40);
		
		psList = new ArrayList<>();
		psList.add(new PsList('I', "1"));
		storeInfo = ReturnModel.selStore("select * from store_info where store_idx = ?", psList);
		txtName = new TextFieldSub(storeInfo.getStore_name(), lblName.getX() + lblName.getWidth() + 10, lblName.getY() + 5, 140, 30);
		txtBNum = new TextFieldSub(storeInfo.getStore_business_number(), lblBNum.getX() + lblBNum.getWidth() + 10, txtName.getY(), 140, 30);
		txtAdress = new TextFieldSub(storeInfo.getStore_address(), txtName.getX(), lblAdress.getY() + 5, 420, 30);
		txtCeo = new TextFieldSub(storeInfo.getStore_ceo(), txtName.getX(), lblCeo.getY() + 5, 140, 30);
		txtPhone = new TextFieldSub(storeInfo.getStore_phone(), txtBNum.getX(), txtCeo.getY(), 140, 30);
		
		JButton btnStoreMod = new JButton("매장 정보 수정");
		btnStoreMod.setBounds(txtPhone.getX(), txtPhone.getY() + txtPhone.getHeight() + 20, 140, 40);
		btnStoreMod.addActionListener(new MemberActionListener(this, storeInfo.getStore_idx(), 'S'));
		
		add(lblName);
		add(lblBNum);
		add(lblAdress);
		add(lblCeo);
		add(lblPhone);
		
		add(txtName);
		add(txtBNum);
		add(txtAdress);
		add(txtCeo);
		add(txtPhone);
		
		add(btnStoreMod);
		
		// 직원 정보
		JPanel jpTopTitle = new JPanel();
		jpTopTitle.setLayout(null);		
		jpTopTitle.setBounds(20, btnStoreMod.getY() + btnStoreMod.getHeight() + 40 , 540, 40);
		
		JLabel topTitleNum = new JLabel("직원 번호",0);
		JLabel topTitleId = new JLabel("직원 ID",0);
		JLabel topTitleName = new JLabel("직원 이름",0);
		JLabel topTitlePass = new JLabel("패스워드",0);
		JLabel topTitleEtc = new JLabel("수정/삭제", 0);
		
		topTitleNum.setBounds(0, 0, 70, 40);
		topTitleNum.setBorder(new LineBorder(Color.black));
		topTitleId.setBounds(topTitleNum.getX() + topTitleNum.getWidth() - 1, 0, 110, 40);
		topTitleId.setBorder(new LineBorder(Color.black));
		topTitleName.setBounds(topTitleId.getX() + topTitleId.getWidth() - 1, 0, 120, 40);
		topTitleName.setBorder(new LineBorder(Color.black));
		topTitlePass.setBounds(topTitleName.getX() + topTitleName.getWidth() - 1, 0, 100, 40);
		topTitlePass.setBorder(new LineBorder(Color.black));
		topTitleEtc.setBounds(topTitlePass.getX() + topTitlePass.getWidth() - 1, 0, 120, 40);
		topTitleEtc.setBorder(new LineBorder(Color.black));
		
		jpTopTitle.add(topTitleNum);
		jpTopTitle.add(topTitleId);
		jpTopTitle.add(topTitleName);
		jpTopTitle.add(topTitlePass);
		jpTopTitle.add(topTitleEtc);
		
		add(jpTopTitle);
				
		jpSetList = new JPanel();
		jpSetList.setLayout(null);
		jpSetList.setPreferredSize(new Dimension(520, 0));
		jpSetList.setBackground(Color.WHITE);
		
		JScrollPane scPane = new JScrollPane(jpSetList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		scPane.getVerticalScrollBar().setUnitIncrement(16);		
		scPane.setBounds(20, jpTopTitle.getY() + jpTopTitle.getHeight() - 1, 517, 180);
		
		add(scPane);
		
		JPanel jpBottomTitle = new JPanel();
		jpBottomTitle.setLayout(null);		
		jpBottomTitle.setBounds(20, scPane.getY() + scPane.getHeight() + 40 , 540, 40);
		
		topBottomNum = new JLabel("0",0);
		topBottoId = new JTextField();
		topBottoName = new JTextField();
		topBottoPass = new JPasswordField();
		topBottoEtc = new JButton("등록");
		topBottoEtc.addActionListener(new MemberActionListener(this, 0, 'I'));
		
		topBottomNum.setBounds(0, 0, 70, 40);
		topBottomNum.setBorder(new LineBorder(Color.black));
		topBottoId.setBounds(topBottomNum.getX() + topBottomNum.getWidth() - 1, 0, 110, 40);
		topBottoId.setBorder(new LineBorder(Color.black));
		topBottoName.setBounds(topBottoId.getX() + topBottoId.getWidth() - 1, 0, 120, 40);
		topBottoName.setBorder(new LineBorder(Color.black));
		topBottoPass.setBounds(topBottoName.getX() + topBottoName.getWidth() - 1, 0, 100, 40);
		topBottoPass.setBorder(new LineBorder(Color.black));
		topBottoEtc.setBounds(topBottoPass.getX() + topBottoPass.getWidth() - 1, 0, 120, 40);
		topBottoEtc.setBorder(new LineBorder(Color.black));
		
		jpBottomTitle.add(topBottomNum);
		jpBottomTitle.add(topBottoId);
		jpBottomTitle.add(topBottoName);
		jpBottomTitle.add(topBottoPass);
		jpBottomTitle.add(topBottoEtc);
		
		add(jpBottomTitle);
		
		setMember();
		
	}
	public void setMember() {
		psList = new ArrayList<>();		
		setMemberList = ReturnModel.selMemberList("select * from member_list", psList);
		setView();
	}
	
	public void setView() {
		ManagerCP.reFresh(jpSetList);
		int listCount = setMemberList.size();
		jpSetList.setPreferredSize(new Dimension(565, listCount * 30 + 30));
		
		for(int i = 0; i < listCount; i++) {
			Member m = setMemberList.get(i);
			JPanel tempJp = new JPanel();
			
			tempJp.setLayout(null);				
			tempJp.setBounds(-1, 30 * i, 560, 30);
			tempJp.setBorder(new LineBorder(Color.GRAY) );
			
			JLabel midNum = new JLabel(m.getMember_idx().toString(),0);
			JLabel midId = new JLabel(m.getMember_id(),0);
			JLabel midName = new JLabel(m.getMember_name(),0);
			JLabel midPass = new JLabel("********",0);
			JButton midBtn = new JButton("수정");
			//JButton tempBtn = new JButton("삭제");
			
			midNum.setBounds(0, 0, 70, 40);
			midId.setBounds(midNum.getX() + midNum.getWidth(), 0, 110, 40);
			midName.setBounds(midId.getX() + midId.getWidth(), 0, 120, 40);
			midPass.setBounds(midName.getX() + midName.getWidth(), 0, 100, 40);
			midBtn.setBounds(midPass.getX() + midPass.getWidth() + 5, 5, 60, 25);
			
			tempJp.add(midNum);
			tempJp.add(midId);
			tempJp.add(midName);
			tempJp.add(midPass);
			tempJp.add(midBtn);
			
			midBtn.addActionListener(new MemberActionListener(this, i, 'U'));
			
			jpSetList.add(tempJp);
		}
		
		jpSetList.revalidate();
		jpSetList.repaint();
	}
	
	public void uptStore() {		
		String sqlUpt = "update store_info";
				sqlUpt += " set STORE_NAME = ?";
				sqlUpt += " , STORE_BUSINESS_NUMBER = ?";
				sqlUpt += " , STORE_ADDRESS = ?";
				sqlUpt += " , STORE_CEO = ?";
				sqlUpt += " , STORE_PHONE = ?";
				sqlUpt += " where STORE_IDX = ?";
		psList = new ArrayList<>();
		psList.add(new PsList('S',txtName.getText()));
		psList.add(new PsList('S',txtBNum.getText()));
		psList.add(new PsList('S',txtAdress.getText()));
		psList.add(new PsList('S',txtCeo.getText()));
		psList.add(new PsList('S',txtPhone.getText()));
		psList.add(new PsList('I',storeInfo.getStore_idx().toString()));
		
		if(OjdbcConnection.insert(sqlUpt, psList)) {
			ManagerCP.viewSuccess("매점 정보가 수정되었습니다.", "수정");
		}else {
			ManagerCP.viewError("장애가 발생하셨습니다.", "에러");
		}
		
	}
	
	public void insMember() {
		int idx = Integer.parseInt(topBottomNum.getText());
		
		if(topBottoId.getText().trim().length() == 0) {
			ManagerCP.viewError("직원 ID를 입력해 주세요.","입력오류");					
			topBottoId.requestFocus();
			return;
		}
		
		if(topBottoName.getText().trim().length() == 0) {
			ManagerCP.viewError("직원 이름을 입력해 주세요.","입력오류");					
			topBottoName.requestFocus();
			return;
		}
		
		if(topBottoPass.getText().trim().length() == 0) {
			ManagerCP.viewError("패스워드를 입력해 주세요.","입력오류");					
			topBottoPass.requestFocus();
			return;
		}
		
		String sqlMember = "";
		psList = new ArrayList<>();
		if(idx > 0) {
			sqlMember += "update member_list";
			sqlMember += " set MEMBER_ID = ?";
			sqlMember += " , MEMBER_NAME = ?";
			sqlMember += " , MEMBER_PASS = ?";
			sqlMember += " where MEMBER_IDX = ?";
			psList.add(new PsList('S',topBottoId.getText()));
			psList.add(new PsList('S',topBottoName.getText()));
			psList.add(new PsList('S',topBottoPass.getText()));
			psList.add(new PsList('S',topBottomNum.getText()));
			System.out.println("직원 정보 수정 : " + idx);
		}else {
			sqlMember += "insert into member_list(MEMBER_IDX, STORE_IDX, MEMBER_ID, MEMBER_NAME, MEMBER_PASS, MEMBER_USE_FLAG, MEMBER_IN_DATE)";
			sqlMember += " values(MEMBER_IDX_SEQ.nextval, ?, ?, ?, ?, 'Y', sysdate)";
			psList.add(new PsList('S',storeInfo.getStore_idx().toString()));
			psList.add(new PsList('S',topBottoId.getText()));
			psList.add(new PsList('S',topBottoName.getText()));
			psList.add(new PsList('S',topBottoPass.getText()));
			System.out.println("직원 정보 추가");
		}
		
		if(OjdbcConnection.insert(sqlMember, psList)) {
			ManagerCP.viewSuccess("매점 정보가 수정되었습니다.", "수정");
		}else {
			ManagerCP.viewError("장애가 발생하셨습니다.", "에러");
		}
		
		topBottomNum.setText("0");
		topBottoId.setText("");
		topBottoName.setText("");
		topBottoPass.setText("");
		topBottoEtc.setText("등록");
		
		setMember();
	}
	
	public void uptMember(int idx) {
		Member m = setMemberList.get(idx);
		topBottomNum.setText(m.getMember_idx().toString());
		topBottoId.setText(m.getMember_id());
		topBottoName.setText(m.getMember_name());
		topBottoPass.setText("");
		topBottoEtc.setText("수정");
		System.out.println("직원 정보 수정 : " + m);
		
	}
	
}

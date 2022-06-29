package manager;

import javax.swing.JFrame;

import database.manager.Member;
import manager.component.ManagerCP;
import manager.member.MemberMain;
import manager.menu.MenuInsertPanel;
import manager.menu.MenuList;
import manager.menu.MenuMainPanel;
import manager.menu.MenuModify;
import manager.menu.MenuSetInsert;
import manager.menu.MenuSetList;
import manager.menu.MenuSetModify;
import manager.sales.SalesGraphView;
import manager.sales.SalesMain;

public class ManagerMain extends JFrame {
	
	public MenuMainPanel menuMainPanel;
	LoginPanel login;
	TopMenuBar  topBar;
	public Member mInfo; 
	
	public ManagerMain() {
		setTitle("관라지 페이지");
		setBounds(500, 300, 240, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		mInfo = new Member();
		
		if(mInfo.getLogin()) {
			//loginOn(mInfo);
		}else {
			//loginOn(mInfo);
			login = new LoginPanel(this);
			add(login);
		}
		
		// 상단메뉴(공통)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new ManagerMain();
		
	}
	
	public void setViewSize(int width, int height) {
		setSize(width, height);
	}
	
	public void loginOn(Member mInfo) {
		//login.setVisible(false);	// 안되는 이유 찾기
		this.mInfo = mInfo;
		setBounds(300, 150, 1000, 800);
		topBar = new TopMenuBar(this);
		menuMainPanel = new MenuMainPanel(this); 
		setJMenuBar(topBar);
		add(menuMainPanel);
	}
	
	public void viewPanel(String pName) {
		ManagerCP.reFresh(menuMainPanel.jpMainMiddle);
		
		switch (pName) {
		case "상품등록":
			menuMainPanel.jpMainMiddle.add(new MenuInsertPanel(this));
		break;
		case "상품목록":
			menuMainPanel.jpMainMiddle.add(new MenuList(this));
		break;
		case "세트메뉴등록":
			menuMainPanel.jpMainMiddle.add(new MenuSetInsert(this));
		break;			
		case "세트메뉴목록":
			menuMainPanel.jpMainMiddle.add(new MenuSetList(this));
		break;
		case "매장관리":
			menuMainPanel.jpMainMiddle.add(new MemberMain(this));
		break;
		case "월 매출조회":
			menuMainPanel.jpMainMiddle.add(new SalesMain(this));
		break;
		case "년 매출조회":
			menuMainPanel.jpMainMiddle.add(new SalesGraphView(this));
		break;
		default :
			menuMainPanel.jpMainMiddle.add(new MenuList(this));
		break;
		}
		
	}
	
	public void viewModifyPanel(String pName, int idx) {
		ManagerCP.reFresh(menuMainPanel.jpMainMiddle);
		switch (pName) {
		case "상품수정":
			menuMainPanel.jpMainMiddle.add(new MenuModify(this, idx));
		break;
		case "세트메뉴수정":
			menuMainPanel.jpMainMiddle.add(new MenuSetModify(this, idx));
		break;			
		default :
			menuMainPanel.jpMainMiddle.add(new MenuList(this));
		break;
		}
	}

}

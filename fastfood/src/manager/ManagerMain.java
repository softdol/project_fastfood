package manager;

import javax.swing.JFrame;

import database.manager.Member;
import manager.menu.ManuMainPanel;

public class ManagerMain extends JFrame {
	
	private ManuMainPanel menuMainPanel;
	private TopMenuBar  topBar;
	public Member mInfo; 
	
	public ManagerMain() {
		setTitle("관라지 페이지");
		setBounds(500, 300, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		mInfo = new Member();
		
		System.out.println(mInfo.getLogin());
		
		if(mInfo.getLogin()) {
			loginOn(mInfo);
		}else {
			loginOn(mInfo);
			//LoginPanel login = new LoginPanel(this);
			//add(login);
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
		this.mInfo = mInfo;
		setBounds(300, 150, 1200, 800);
		topBar = new TopMenuBar();
		menuMainPanel = new ManuMainPanel(this); 
		setJMenuBar(topBar);
		add(menuMainPanel);
	}
}

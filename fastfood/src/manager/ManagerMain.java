package manager;

import javax.swing.JFrame;

import database.manager.Member;
import manager.menu.ManuMainPanel;

public class ManagerMain extends JFrame {
	
	private ManuMainPanel menuMainPanel;
	LoginPanel login;
	private TopMenuBar  topBar;
	public Member mInfo; 
	
	public ManagerMain() {
		setTitle("������ ������");
		setBounds(500, 300, 300, 200);
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
		
		// ��ܸ޴�(����)
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new ManagerMain();
		
	}
	
	public void setViewSize(int width, int height) {
		setSize(width, height);
	}
	
	public void loginOn(Member mInfo) {
		//login.setVisible(false);	// �ȵǴ� ���� ã��
		this.mInfo = mInfo;
		setBounds(300, 150, 1200, 800);
		topBar = new TopMenuBar();
		menuMainPanel = new ManuMainPanel(this); 
		setJMenuBar(topBar);
		add(menuMainPanel);
	}
}

package manager;

import javax.swing.JFrame;

import database.manager.Member;
import manager.menu.MenuInsertPanel;
import manager.menu.MenuList;
import manager.menu.MenuMainPanel;
import manager.menu.MenuSetInsert;
import manager.menu.MenuSetList;

public class ManagerMain extends JFrame {
	
	public MenuMainPanel menuMainPanel;
	LoginPanel login;
	TopMenuBar  topBar;
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
		topBar = new TopMenuBar(this);
		menuMainPanel = new MenuMainPanel(this); 
		setJMenuBar(topBar);
		add(menuMainPanel);
	}
	
	public void viewPanel(String pName) {
		
		switch (pName) {
		case "��ǰ���":
			menuMainPanel.jpMainMiddle.add(new MenuInsertPanel(this));
		break;
		case "��ǰ���":
			menuMainPanel.jpMainMiddle.add(new MenuList(this));
		break;
		case "��Ʈ�޴����":
			menuMainPanel.jpMainMiddle.add(new MenuSetInsert(this));
		break;			
		case "��Ʈ�޴����":
			menuMainPanel.jpMainMiddle.add(new MenuSetList(this));
		break;			
		default :
			menuMainPanel.jpMainMiddle.add(new MenuInsertPanel(this));
		break;
		}
		
	}

}

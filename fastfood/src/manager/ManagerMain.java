package manager;

import javax.swing.JFrame;

import manager.menu.ManuMainPanel;

public class ManagerMain extends JFrame {
	
	public ManagerMain() {
		setTitle("관라지 페이지");
		setBounds(300, 150, 1200, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		LoginPanel login = new LoginPanel(getWidth(), getHeight());
		//add(login);
		
		// 상단메뉴(공통)
		TopMenuBar  topBar = new TopMenuBar();
		setJMenuBar(topBar);
		
		ManuMainPanel menuMainPanel = new ManuMainPanel();  
		add(menuMainPanel);
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		
		new ManagerMain();
		
	}
	
}

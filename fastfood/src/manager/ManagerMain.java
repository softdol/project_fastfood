package manager;

import javax.swing.JFrame;

import manager.menu.ManuMainPanel;

public class ManagerMain extends JFrame {
	
	public ManagerMain() {
		setTitle("관라지 페이지");
		setBounds(700, 350, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		LoginPanel login = new LoginPanel(getWidth(), getHeight());
		//add(login);
		
		
		ManuMainPanel menuMainPanel = new ManuMainPanel();  
		add(menuMainPanel);
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		
		new ManagerMain();
		
	}
	
}

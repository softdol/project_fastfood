package manager;

import javax.swing.JFrame;

public class ManagerMain extends JFrame {
	
	public ManagerMain() {
		setTitle("관라지 페이지");
		setBounds(700, 350, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		LoginPanel login = new LoginPanel(getWidth(), getHeight());		
		
		add(login);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new ManagerMain();
		
	}
	
}

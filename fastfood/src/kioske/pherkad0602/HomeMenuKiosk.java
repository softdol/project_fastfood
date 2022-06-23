package kioske.pherkad0602;

import javax.swing.JFrame;

import kioske.pherkad0602.ui.Category;
import kioske.pherkad0602.ui.HomePanel;
import kioske.pherkad0602.ui.PayPanel;

public class HomeMenuKiosk extends JFrame{
	
	public HomeMenuKiosk() {
			
		setLayout(null);
		
	
		Category cate = new Category();		
		add(cate.Category());
		
		HomePanel home = new HomePanel();		
		add(home.HomePanel());
		
		PayPanel pay = new PayPanel();
		add(pay.PayPanel());
		
		
	
		setBounds(510,0,900,1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    setResizable(false);

	}
	
	public static void main(String[] args) {
		
		new HomeMenuKiosk();

	}
}

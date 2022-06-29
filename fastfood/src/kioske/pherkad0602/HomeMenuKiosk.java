package kioske.pherkad0602;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kioske.pherkad0602.ui.Category;
import kioske.pherkad0602.ui.HomePanel;
import kioske.pherkad0602.ui.MainPanel;
import kioske.pherkad0602.ui.MenuPanel;
import kioske.pherkad0602.ui.PayPanel;

public class HomeMenuKiosk extends JPanel{
	
	MainPanel main;
	
	public void viewMenu(String name) {
		main.cardLayoutManager.show(main, name);
		System.out.println(name);
	}
	
	public HomeMenuKiosk() {
		
		setLayout(null);

		Category cate = new Category(this);		
		add(cate);
		
		main = new MainPanel(this);
		//main.setBounds(200, 0, 684, 800);
		add(main);
		
		PayPanel pay = new PayPanel();
		add(pay);
		
		
		setBounds(0,0,900,1040);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    //setResizable(false);

	}
	
	public static void main(String[] args) {
		
		new HomeMenuKiosk();

	}

}

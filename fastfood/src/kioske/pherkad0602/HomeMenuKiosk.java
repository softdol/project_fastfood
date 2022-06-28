package kioske.pherkad0602;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import kioske.pherkad0602.ui.Category;
import kioske.pherkad0602.ui.HomePanel;
import kioske.pherkad0602.ui.MainPanel;
import kioske.pherkad0602.ui.MenuPanel;
import kioske.pherkad0602.ui.PayPanel;

public class HomeMenuKiosk extends JFrame{
	
	MainPanel main;
	
	public void viewMenu(int iCate) {
		System.out.println(iCate);
		main.cardLayoutManager.show(main, "menu" + iCate);
	}
	
	public HomeMenuKiosk() {
		
		setLayout(null);
		
		String sql1 = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
		String sql2 = "SELECT * FROM Menu_subcategory WHERE menu_category_IDX = 1";
		

		Category cate = new Category(this);		
		add(cate);
		
		main = new MainPanel();
		//main.setBounds(200, 0, 684, 800);
		add(main);
		
//		PayPanel pay = new PayPanel();
//		add(pay.PayPanel());
		
	
		setBounds(510,0,900,1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    setResizable(false);

	}
	
	public static void main(String[] args) {
		
		new HomeMenuKiosk();

	}

}

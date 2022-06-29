package kioske.pherkad0602;

import java.util.ArrayList;

import javax.swing.JFrame;

import database.model.PsList;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.ui.Category;
import kioske.pherkad0602.ui.MainPanel;
import kioske.pherkad0602.ui.OrderCheck;
import kioske.pherkad0602.ui.PayPanel;

public class HomeMenuKiosk extends JFrame{
	
	MainPanel main;
	PayPanel pay;
	ArrayList orderList = new ArrayList<>();
	int sum = 0;
	
	
	public void order(int idx) {
		new OrderCheck(this, idx);
	}
	
	public void setPrice(int idx) {
		orderList.add(idx);
		
		String sql = "SELECT * FROM Menu WHERE Menu_IDX = ?";
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('I', String.valueOf(idx)));
		ArrayList<MenuDatabase> menuList = ReturnModel.selMenuList1(sql, psList);
		sum += menuList.get(0).getMenu_price();
		System.out.println(idx);
		pay.price.setText(String.valueOf(sum) +" ¿ø");
	}
	
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
		
		pay = new PayPanel();
		add(pay);
		
		
		setBounds(510,0,900,1040);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    setResizable(false);

	}
	
	public static void main(String[] args) {
		
		new HomeMenuKiosk();

	}

}

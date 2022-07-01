package kioske.pherkad0602;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.ui.Category;
import kioske.pherkad0602.ui.MainPanel;
import kioske.pherkad0602.ui.OrderCheck;
import kioske.pherkad0602.ui.PayPanel;
import oracle.net.aso.f;

public class HomeMenuKiosk extends JPanel{
	Main_JFrame frame;
	MainPanel main;
	PayPanel pay;
//	public ArrayList orderList = new ArrayList<>();
	int sum = 0;
	public HomeMenuKiosk() {
		// TODO Auto-generated constructor stub
	}
	
	public void order(MenuDatabase menu, Main_JFrame frame) {
		new OrderCheck(this, menu, frame);
	}
	
	public void setPrice(MenuDatabase menu) {
		int sum = 0;
		frame.orderList.add(new Order_list(menu, 1, 0));

		for(int i = 0; i < frame.orderList.size(); i ++) {
			sum += frame.orderList.get(i).getORDER_PRICE();
		}

		pay.price.setText(String.valueOf(sum) +" ��");
	}
	
	public void setPrice(int idx) {
		int sum = 0;
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu where menu_idx = ?";
	  	psList.add(new PsList('I', String.valueOf(idx)));
	  	MenuDatabase menu = ReturnModel.menuList(sql, psList);
		frame.orderList.add(new Order_list(menu, 1, 0));
		for(int i = 0; i < frame.orderList.size(); i ++) {
			sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
		}
		System.out.println("setPrice2 : " + sum + " : " + idx);	
		pay.price.setText(String.valueOf(sum) +" ��");	
	}
	
	public void setPrice(int idx, int setIdx) {
		int sum1 = 0;
		int sum2 = 0;
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu where menu_idx = ?";
	  	psList.add(new PsList('I', String.valueOf(idx)));
	  	MenuDatabase menu = ReturnModel.menuList(sql, psList);
		frame.orderList.add(new Order_list(menu, 1, setIdx));
		if(frame.orderList.get(1).get)
		for(int i = 0; i < frame.orderList.size(); i ++) {
			sum1 += frame.orderList.get(i).getORDER_PRICE_TOTAL();
		}
		System.out.println("setPrice2 : " + sum + " : " + idx);	
		pay.price.setText(String.valueOf(sum) +" ��");	
	}
	
	
	public void viewMenu(String name) {
		main.cardLayoutManager.show(main, name);
		System.out.println(name);
	}
	
	
	public void orderPlus(MenuDatabase menu) {
		// TODO Auto-generated method stub
		frame.orderList.add(new Order_list(menu, 1, 0));
	}
	
	public void orderReset() {
		frame.orderList.removeAll(frame.orderList);
		pay.price.setText(" ��");
		sum = 0;
	}

	
	public HomeMenuKiosk(Main_JFrame frame, int idx) {
		
		this.frame = frame;
		pay = new PayPanel(this, frame);
		add(pay);
		
		setLayout(null);

		Category cate = new Category(this);		
		add(cate);
		
		main = new MainPanel(this, frame);
		//main.setBounds(200, 0, 684, 800);
		add(main);
		
		
		
		
		setBounds(0,0,900,1040);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	    //setResizable(false);
		
		System.out.println(idx);

	}
	
	public static void main(String[] args) {

	}


	
}

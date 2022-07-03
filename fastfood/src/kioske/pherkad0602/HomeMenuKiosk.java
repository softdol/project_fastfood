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
import manager.component.ManagerCP;
import oracle.net.aso.f;
import oracle.security.o3logon.a;

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
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}

		pay.price.setText(ManagerCP.viewWon(sum) +" 원");
	}
	
	public void setPrice(int idx) {
		int sum = 0;
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu where menu_idx = ?";
	  	psList.add(new PsList('I', String.valueOf(idx)));
	  	MenuDatabase menu = ReturnModel.menuList(sql, psList);
		frame.orderList.add(new Order_list(menu, 1, 0));
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		System.out.println("setPrice2 : " + sum + " : " + idx);	
		pay.price.setText(ManagerCP.viewWon(sum) +" 원");	
	}
	
	public void setPrice(int menuIdx, int drinkIdx, int sideIdx,  int setIdx) {
		int sum = 0;
		int[] temp = new int[3];

		temp[0] = menuIdx;
		temp[1] = drinkIdx;
		temp[2] = sideIdx;
		
		for (int i = 0; i < temp.length; i++) {
			ArrayList<PsList> psList = new ArrayList<>();
			String sql = "select * from menu where menu_idx = ?";
		  	psList.add(new PsList('I', String.valueOf(temp[i])));
		  	MenuDatabase menu = ReturnModel.menuList(sql, psList);
			frame.orderList.add(new Order_list(menu, 1, setIdx));
			System.out.println("[[[[" + menu.getMenu_name() + " : " + menu.getMenu_price());

		}
		
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		System.out.println("setPrice2 : " + sum + " : " +menuIdx);	
		pay.price.setText(ManagerCP.viewWon(sum) +" 원");	
	}
	
	public void setPrice() {
		int sum = 0;
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}

		pay.price.setText(ManagerCP.viewWon(sum) +" 원");	
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
		pay.price.setText(" 원");
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

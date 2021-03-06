package kioske.YounukLee7;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;
import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.YounukLee7.kioskeUI.Cart_down;
import kioske.YounukLee7.kioskeUI.Cart_mid;
import kioske.YounukLee7.kioskeUI.Cart_up;
import kioske.pherkad0602.HomeMenuKiosk;
import manager.component.ManagerCP;

public class Last_JPanel extends JPanel{
	
	Cart_mid mid;
	Cart_down down;
	Main_JFrame frame;
	Last_JFrame screen;
	HomeMenuKiosk hMain;

	
	public Last_JPanel(Main_JFrame frame,  HomeMenuKiosk hMain) {
		this.frame = frame;
		//this.screen = screen;
		this.hMain = hMain;
		
		Cart_up up = new Cart_up();
		add(up);
		
	
//		System.out.println(orderList);
		
		//mid = new Cart_mid(screen, orderList);
		//add(mid);
		
		//ArrayList<Order_list> orderList2 = new ArrayList<>();
		
		mid = new Cart_mid(this, frame);
		add(mid);
		
//		JButton btnButton = new JButton("1");
//		btnButton.setBounds(100,200,100,50);
//		btnButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println(1);
//				screen.viewOrder(orderList);
//			}
//		});
//		add(btnButton);
//		//screen.viewOrder(orderList);
		
        
		down = new Cart_down(screen, frame, hMain);
		add(down);
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
	
	public void SetPrice() {
		int sum = 0;
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		down.allmoney.setText(ManagerCP.viewWon(sum) + "??");
	}
}

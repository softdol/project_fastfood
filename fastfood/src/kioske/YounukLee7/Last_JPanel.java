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

public class Last_JPanel extends JPanel{
	
	Cart_mid mid;

	public Last_JPanel(Last_JFrame screen) {
		
		Cart_up up = new Cart_up();
		add(up);
		
		ArrayList<Order_list> orderList = new ArrayList<>();
		ArrayList<PsList> psList = new ArrayList<>();
		
		String sql = "select * from menu";
		
		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
		
		for(int i = 0; i < 2; i++) {
			Menu m = menuList.get((int)(Math.random() * menuList.size()));
			orderList.add(new Order_list(m, (int)(Math.random() * 5) + 1, 0));
		}
		
		//mid = new Cart_mid(screen, orderList);
		//add(mid);
		
		ArrayList<Order_list> orderList2 = new ArrayList<>();
		
		mid = new Cart_mid(screen, orderList2);
		
		add(mid);
		JButton btnButton = new JButton("1");
		btnButton.setBounds(100,200,100,50);
		btnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(1);
				screen.viewOrder(orderList);
			}
		});
		add(btnButton);
		//screen.viewOrder(orderList);
		
        
		Cart_down down = new Cart_down(screen);
		add(down);
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
}

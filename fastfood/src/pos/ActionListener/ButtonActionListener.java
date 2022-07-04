package pos.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

import database.manager.Menu;
import pos.Order;
import pos.Pos_Burger;

public class ButtonActionListener implements ActionListener{
	Menu m;
	Pos_Burger main;
	
	public ButtonActionListener(Pos_Burger main, Menu m) {
		this.main = main;
		this.m = m;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//클릭했을 때 메뉴 정보 가져오기 
	
		JButton itemBtn = (JButton)e.getSource();
		//System.out.println(itemBtn.getText());
		
		String product = itemBtn.getText();
		
		// ORDERLIST에 메뉴리스트를 넣어라 
		
		int qty = 1;
		
		
		main.orderlist.add(new Order(m,qty,0));
	
		
		
//		for(Order o : main.orderlist) {
//			System.out.println(o.getMenu_name() + " " + o.getMenu_idx());
//		};
		
		main.setOrderlist();
		//ArrayList<Order> orderlist = new ArrayList<>();
		//main.orderlist.add(new Order(m,1,0));
		
		// orderlist 객체를 가지고, 테이블에 넣어라 (for문에 테이블 생성)해라 
		
		
		
	}

	
}

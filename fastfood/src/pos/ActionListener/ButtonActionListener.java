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
		//Ŭ������ �� �޴� ���� �������� 
	
		JButton itemBtn = (JButton)e.getSource();
		//System.out.println(itemBtn.getText());
		
		String product = itemBtn.getText();
		
		// ORDERLIST�� �޴�����Ʈ�� �־�� 
		
		int qty = 1;
		
		
		main.orderlist.add(new Order(m,qty,0));
	
		
		
//		for(Order o : main.orderlist) {
//			System.out.println(o.getMenu_name() + " " + o.getMenu_idx());
//		};
		
		main.setOrderlist();
		//ArrayList<Order> orderlist = new ArrayList<>();
		//main.orderlist.add(new Order(m,1,0));
		
		// orderlist ��ü�� ������, ���̺� �־�� (for���� ���̺� ����)�ض� 
		
		
		
	}

	
}

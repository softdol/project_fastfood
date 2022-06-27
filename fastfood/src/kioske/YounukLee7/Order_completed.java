package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Order_completed_down;

public class Order_completed extends JFrame{
	
	public Order_completed() {
		
		Logo_MenuName_Panel logo = new Logo_MenuName_Panel();
		add(logo.Logo_MenuName_Panel());
		
		Order_completed_down down = new Order_completed_down();
		add(down.Order_completed_down());
		
		setLayout(null);
		setTitle("주문 완료");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Order_completed();
	}
}

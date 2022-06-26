package kioske.YounukLee7;


import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Payment_down;
import kioske.YounukLee7.kioskeUI.Select_Payment_mid;

public class Select_Payment extends JFrame{

	public Select_Payment() {
		
		Logo_MenuName_Panel logo = new Logo_MenuName_Panel();
		add(logo.Logo_MenuName_Panel());
		
		Select_Payment_mid mid = new Select_Payment_mid();
		add(mid.Select_Payment_mid());
		
		Select_Payment_down down = new Select_Payment_down();
		add(down.Select_Payment_down());
		
		setLayout(null);
		setTitle("결제 선택창");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Select_Payment();
	}
}

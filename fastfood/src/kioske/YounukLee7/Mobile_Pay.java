package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Down_yes_no_Button;
import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Mobile_Pay_mid;
import oracle.net.aso.b;

public class Mobile_Pay extends JFrame{
	
	public Mobile_Pay() {
		
		Logo_MenuName_Panel logo = new Logo_MenuName_Panel();
		add(logo);
		
		Mobile_Pay_mid mid = new Mobile_Pay_mid();
		add(mid);
		
		Down_yes_no_Button button = new Down_yes_no_Button();
		add(button);
		
		setLayout(null);
		setTitle("ÄíÆù °áÁ¦");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Mobile_Pay();
	}
}

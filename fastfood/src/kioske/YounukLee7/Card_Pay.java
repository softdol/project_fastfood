package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Card_Pay_mid;
import kioske.YounukLee7.kioskeUI.Down_yes_no_Button;
import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;

public class Card_Pay extends JFrame{
	
	public Card_Pay() {
		
		Logo_MenuName_Panel logo = new Logo_MenuName_Panel();
		add(logo);
		
		Card_Pay_mid mid = new Card_Pay_mid();
		add(mid);
		
		Down_yes_no_Button button = new Down_yes_no_Button();
		add(button);
		
		setLayout(null);
		setTitle("카드 결체");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Card_Pay();
	}
}

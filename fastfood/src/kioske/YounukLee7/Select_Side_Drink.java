package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;

public class Select_Side_Drink extends JFrame{

	
	public Select_Side_Drink() {
		
		Logo_MenuName_Panel logo_MenuName_Panel = new Logo_MenuName_Panel();
		add(logo_MenuName_Panel);
		
		Select_Side_Drink_down down = new Select_Side_Drink_down();
		add(down);
		
		setLayout(null);
		setTitle("사이드 또는 음료 변경 후 담기");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Side_Drink();
	}
}

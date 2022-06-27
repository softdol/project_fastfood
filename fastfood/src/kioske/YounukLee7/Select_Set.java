package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_down;

public class Select_Set extends JFrame{

	public Select_Set() {
		
		Logo_MenuName_Panel logo_MenuName_Panel = new Logo_MenuName_Panel();
		add(logo_MenuName_Panel);
		
		Select_Set_down down = new Select_Set_down();
		add(down);
		
		setLayout(null);
		setTitle("단품 또는 세트");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Select_Set();
	}
}

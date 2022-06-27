package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_Size_down;


public class Select_Set_Size extends JFrame{

	public Select_Set_Size() {
		
//		Logo_MenuName_Panel logo = new Logo_MenuName_Panel();
//		add(logo);
//		
//		Select_Set_Size_down down = new Select_Set_Size_down();
//		add(down);
		
		setLayout(null);
		setTitle("일반세트 또는 라지세트");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Set_Size();
	}
}

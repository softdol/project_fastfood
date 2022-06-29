package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Error_Image_down;
import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;

public class Error_Image extends JFrame{
	
	public Error_Image() {
		
//		Logo_MenuName_Panel logo = new Logo_MenuName_Panel();
//		add(logo);
//		
//		Error_Image_down down = new Error_Image_down();
//		add(down);
		
		setLayout(null);
		setTitle("Error_Image");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Error_Image();
	}
}

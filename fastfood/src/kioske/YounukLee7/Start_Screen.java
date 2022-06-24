package kioske.YounukLee7;


import javax.swing.JFrame;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;

public class Start_Screen extends JFrame{

	public Start_Screen() {
	
		Start_Screen_kiosk start_Screen_kiosk = new Start_Screen_kiosk();
		add(start_Screen_kiosk.Start_Screen_kiosk());
		
		setLayout(null);
		setTitle("Ã¹ È­¸é");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Start_Screen();
	}
}

package kioske.YounukLee7;

import javax.swing.JFrame;
import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;

public class Select_Takeout extends JFrame{
	
	public Select_Takeout() {
		
		Select_Takeout_up up = new Select_Takeout_up();
		add(up.Select_Takeout_up());
		
		Select_Takeout_down down = new Select_Takeout_down();
		add(down.Select_Takeout_down());
		
		setLayout(null);
		setTitle("매장식사 또는 포장");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Takeout();
	}
}

package kioske.YounukLee7;

import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;

public class Main_JPanel extends JPanel{

	public Main_JPanel() {
		
//		Start_Screen_kiosk start_Screen_kiosk = new Start_Screen_kiosk();
//		add(start_Screen_kiosk.Start_Screen_kiosk());
		
		Select_Takeout_up up = new Select_Takeout_up();
		add(up.Select_Takeout_up());
		
		Select_Takeout_down down = new Select_Takeout_down();
		add(down.Select_Takeout_down());
		
		setBounds(0,0,900,1040);
	}
}

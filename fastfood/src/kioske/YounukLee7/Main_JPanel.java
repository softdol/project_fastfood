package kioske.YounukLee7;

import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;

public class Main_JPanel extends JPanel{
	
	Start_Screen_kiosk start_Screen_kiosk;
	Select_Takeout_up up;
	Select_Takeout_down down;

	public Main_JPanel() {
		
//		start_Screen_kiosk = new Start_Screen_kiosk();
//		add(start_Screen_kiosk.Start_Screen_kiosk());
		
		up = new Select_Takeout_up();
		add(up.Select_Takeout_up());
		down = new Select_Takeout_down();
		add(down.Select_Takeout_down());
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
	
}

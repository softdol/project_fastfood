package kioske.YounukLee7;

import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;

public class Main_JPanel extends JPanel{
	
	
	public Main_JPanel(Start_Screen screen) {
		
		Start_Screen_kiosk start_Screen_kiosk = new Start_Screen_kiosk(screen);
		add(start_Screen_kiosk);
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
	
}

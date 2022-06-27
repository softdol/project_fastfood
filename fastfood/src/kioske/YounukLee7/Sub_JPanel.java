package kioske.YounukLee7;

import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_down;

public class Sub_JPanel extends JPanel{
	
	public Sub_JPanel(Sub_JFrame screen) {
		
		Logo_MenuName_Panel logo_MenuName_Panel = new Logo_MenuName_Panel();
		add(logo_MenuName_Panel);
		
		Select_Set_down down = new Select_Set_down(screen);
		add(down);
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
}

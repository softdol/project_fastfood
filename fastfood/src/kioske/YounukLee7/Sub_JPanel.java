package kioske.YounukLee7;

import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import oracle.jdbc.driver.json.tree.JsonpPrimitive.JsonpIntervalYMImpl;

public class Sub_JPanel extends JPanel{
	
	public Sub_JPanel(Sub_JFrame screen, int idx) {
		
//		Logo_MenuName_Panel logo_MenuName_Panel = new Logo_MenuName_Panel(idx, null);
//		add(logo_MenuName_Panel);
//		
//		Select_Set_down down = new Select_Set_down(screen, idx);
//		add(down);
		Main_JFrame main_JFrame = new Main_JFrame();
		
		Select_Side_Drink_down down = new Select_Side_Drink_down(main_JFrame, 0, 0, 0, 0);
		add(down);
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
}

package kioske.YounukLee7;

import java.util.ArrayList;

import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Cart_down;
import kioske.YounukLee7.kioskeUI.Cart_mid;
import kioske.YounukLee7.kioskeUI.Cart_up;

public class Last_JPanel extends JPanel{

	public Last_JPanel(Last_JFrame screen) {
		
		Cart_up up = new Cart_up();
		add(up);
		
		Cart_mid mid = new Cart_mid(screen);
		add(mid);
        
		Cart_down down = new Cart_down(screen);
		add(down);
		
		setLayout(null);
		setBounds(0,0,900,1040);
	}
}

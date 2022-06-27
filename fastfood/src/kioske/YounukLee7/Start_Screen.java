package kioske.YounukLee7;


import javax.swing.JFrame;
import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;
import manager.component.ManagerCP;

public class Start_Screen extends JFrame{
	
	public void veiw() {
		ManagerCP.reFresh(null);
	}

	public Start_Screen() {
		
		Main_JPanel panel = new Main_JPanel(this);
		add(panel);
		
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

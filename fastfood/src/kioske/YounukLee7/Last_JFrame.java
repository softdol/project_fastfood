package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Card_Pay_mid;
import kioske.YounukLee7.kioskeUI.Down_yes_no_Button;
import kioske.YounukLee7.kioskeUI.Error_Image_down;
import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Mobile_Pay_mid;
import kioske.YounukLee7.kioskeUI.Order_completed_down;
import kioske.YounukLee7.kioskeUI.Select_Payment_down;
import kioske.YounukLee7.kioskeUI.Select_Payment_mid;
import manager.component.ManagerCP;

public class Last_JFrame extends JFrame{
	
	Last_JPanel panel;
	
	public void veiw_Select_Payment() {
		ManagerCP.reFresh(panel);
		//panel.add(new Logo_MenuName_Panel());
		panel.add(new Select_Payment_mid(this));
		panel.add(new Select_Payment_down(this));
	}
	
	public void veiw_Card_Pay() {
		ManagerCP.reFresh(panel);
		//panel.add(new Logo_MenuName_Panel());
		panel.add(new Card_Pay_mid());
		panel.add(new Down_yes_no_Button(this));
	}
	
	public void veiw_Mobile_Pay() {
		ManagerCP.reFresh(panel);
		//panel.add(new Logo_MenuName_Panel());
		panel.add(new Mobile_Pay_mid());
		panel.add(new Down_yes_no_Button(this));
	}
	
	public void veiw_Error() {
		ManagerCP.reFresh(panel);
		//panel.add(new Logo_MenuName_Panel());
		panel.add(new Error_Image_down());
	}
	
	public void veiw_Order_completed() {
		ManagerCP.reFresh(panel);
		//panel.add(new Logo_MenuName_Panel());
		panel.add(new Order_completed_down());
	}
	
	
	
	public Last_JFrame() {
		
		panel = new Last_JPanel(this);
		add(panel);
		
		setLayout(null);
		setTitle("Da∆»æ∆");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Last_JFrame();
	}
}

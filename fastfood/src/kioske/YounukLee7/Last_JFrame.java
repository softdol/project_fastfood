package kioske.YounukLee7;

import java.util.ArrayList;

import javax.swing.JFrame;

import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.YounukLee7.kioskeUI.Card_Pay_mid;
import kioske.YounukLee7.kioskeUI.Cart_down;
import kioske.YounukLee7.kioskeUI.Cart_mid;
import kioske.YounukLee7.kioskeUI.Cart_up;
import kioske.YounukLee7.kioskeUI.Completed_up;
import kioske.YounukLee7.kioskeUI.Down_yes_no_Button;
import kioske.YounukLee7.kioskeUI.Error_Image_down;
import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Mobile_Pay_mid;
import kioske.YounukLee7.kioskeUI.Order_completed_down;
import kioske.YounukLee7.kioskeUI.Payment_up;
import kioske.YounukLee7.kioskeUI.Select_Payment_down;
import kioske.YounukLee7.kioskeUI.Select_Payment_mid;
import kioske.pherkad0602.HomeMenuKiosk;
import manager.component.ManagerCP;

public class Last_JFrame extends JFrame{
	
	Last_JPanel panel;
	Main_JFrame frame;
	HomeMenuKiosk hMain;
//	public void veiw_Cart() {
//		ManagerCP.reFresh(panel);
//		panel.add(new Cart_up());
//		panel.add(new Cart_mid(this));
//		panel.add(new Cart_down(this));
//	}
//	
//	public void viewOrder(ArrayList<Order_list> orderList) {
//		
//		ManagerCP.reFresh(panel.mid);
//		
//	//	 panel.mid.add(new Cart_mid(this, orderList));
//		
//	}
	
//	public void veiw_Select_Payment(Main_JFrame frame) {
//		
//		// 여기서부터 frame 끝가지 가지고 가야합니다
//		ManagerCP.reFresh(panel);
//		panel.add(new Payment_up());
//		panel.add(new Select_Payment_mid(this));
//		panel.add(new Select_Payment_down(this));
//	}
	
//	public void veiw_Card_Pay() {
//		ManagerCP.reFresh(panel);
//		panel.add(new Payment_up());
//		panel.add(new Card_Pay_mid());
//		panel.add(new Down_yes_no_Button(this));
//	}
//	
//	public void veiw_Mobile_Pay() {
//		ManagerCP.reFresh(panel);
//		panel.add(new Payment_up());
//		panel.add(new Mobile_Pay_mid());
//		panel.add(new Down_yes_no_Button(this));
//	}
	
	public void veiw_Error() {
		ManagerCP.reFresh(panel);
		panel.add(new Payment_up());
		panel.add(new Error_Image_down());
	}
	
	public void veiw_Order_completed() {
		ManagerCP.reFresh(panel);
		panel.add(new Completed_up());
		panel.add(new Order_completed_down());
	}
	
	
	
	public Last_JFrame(Main_JFrame frame, HomeMenuKiosk hMain) {
		this.frame = frame;
		this.hMain = hMain;
		panel = new Last_JPanel(frame, hMain);
		add(panel);
		
		setLayout(null);
		setTitle("Da팔아");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		//new Last_JFrame();
	}
}

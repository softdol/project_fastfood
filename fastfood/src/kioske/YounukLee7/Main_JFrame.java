package kioske.YounukLee7;


import javax.swing.JFrame;
import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;
import kioske.pherkad0602.HomeMenuKiosk;
import manager.component.ManagerCP;

public class Main_JFrame extends JFrame{
	
	Main_JPanel panel;
	
	
	// 첫 화면에서 -> 포장 선택 화면으로
	public void veiw_takeout() {
		ManagerCP.reFresh(panel);
		panel.add(new Select_Takeout_up());
		panel.add(new Select_Takeout_down(this));
	}
	
	// 형래님 홈으로 가기
	public void veiw_Home(String check) {
		ManagerCP.reFresh(panel);
		panel.add(new HomeMenuKiosk());
	}
	

	public Main_JFrame() {
		
		panel = new Main_JPanel(this);
		add(panel);
		
		setLayout(null);
		setTitle("Da팔아");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main_JFrame();
	}
}

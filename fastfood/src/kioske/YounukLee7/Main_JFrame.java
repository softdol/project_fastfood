package kioske.YounukLee7;


import javax.swing.JFrame;
import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;
import manager.component.ManagerCP;

public class Main_JFrame extends JFrame{
	
	Main_JPanel panel;
	
	// ù ȭ�鿡�� -> ���� ���� ȭ������
	public void veiw_takeout() {
		ManagerCP.reFresh(panel);
		panel.add(new Select_Takeout_up());
		panel.add(new Select_Takeout_down());
	}
	

	public Main_JFrame() {
		
		panel = new Main_JPanel(this);
		add(panel);
		
		setLayout(null);
		setTitle("Da�Ⱦ�");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main_JFrame();
	}
}

package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_Size_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import manager.component.ManagerCP;

public class Sub_JFrame extends JFrame {
	
	Sub_JPanel panel;
	
	// 단품,세트 중 세트 선택 시 라지세트 선택 화면으로 감
	public void veiw_Set_Size() {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel());
		panel.add(new Select_Set_Size_down(this));
	}
	
	public void veiw_Select_Side_Drink() {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel());
		panel.add(new Select_Side_Drink_down());
	}
	
	public Sub_JFrame() {
		
		panel = new Sub_JPanel(this);
		add(panel);
		
		setLayout(null);
		setTitle("Da팔아");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Sub_JFrame();
	}
}

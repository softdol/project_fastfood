package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_Size_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import kioske.pherkad0602.HomeMenuKiosk;
import manager.component.ManagerCP;

public class Sub_JFrame extends JFrame {
	
	Sub_JPanel panel;
	
	// 단품,세트 중 세트 선택 시 라지세트 선택 화면으로 감
//	public void veiw_Set_Size(int idx, String  set) {
//		ManagerCP.reFresh(panel);
//		panel.add(new Logo_MenuName_Panel(idx,set));
//		panel.add(new Select_Set_Size_down(this, idx));
//	}
	
	// 형래님 홈으로 가기
//	public void veiw_Home_giveIDX(int menuidx) {
//		ManagerCP.reFresh(panel);
//		panel.add(new HomeMenuKiosk());
//	}
	
//	public void veiw_Select_Side_Drink(int idx, String  set, int setidx, int sideidx, int drinkidx) {
//		ManagerCP.reFresh(panel);
//		panel.add(new Logo_MenuName_Panel(idx,set));
//		panel.add(new Select_Side_Drink_down(this, idx,setidx,sideidx,drinkidx));
//	}
	
	public Sub_JFrame() {
		
//		panel = new Sub_JPanel(this,1);
//		add(panel);
		
//		Main_JFrame main_JFrame = new Main_JFrame();
//		
//		Select_Side_Drink_down down = new Select_Side_Drink_down(main_JFrame, 0, 0, 0, 0);
//		add(down);
		
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

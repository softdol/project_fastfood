package kioske.YounukLee7;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import manager.component.ManagerCP;

public class Set_Option extends JFrame{
	HomeMenuKiosk hMain;
	JPanel panel;
	
	public void veiw_Select_Side_Drink(int menuidx, String  set, int setidx, int sideidx, int drinkidx) {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel(menuidx,set));
		panel.add(new Select_Side_Drink_down(this, menuidx, setidx, sideidx, drinkidx,hMain));
	}
	
	/**
	 * 미구현 - 바로 위에 사이드, 음료 변경 카트담기 화면에서 사이드변경 클릭 시 -> 사이드변경 화면으로 감
	 * 나머진 받은대로 그대로 주고 sideidx만 바꿔 주면 될듯함
	 * @param menuidx
	 * @param set
	 * @param setidx
	 * @param sideidx - 0이 들어있을 예정
	 * @param drinkidx
	 */
	public void veiw_Select_Side(int menuidx, String  set, int setidx, int sideidx, int drinkidx, int cartidx) {
		ManagerCP.reFresh(panel);
		panel.add(new kiosk7(this, menuidx, set, setidx, sideidx, drinkidx, cartidx));
	}
	
	/**
	 * 미구현 - 바로 위에 사이드, 음료 변경 카트담기 화면에서 음료변경 클릭 시 -> 음료변경 화면으로 감
	 * 나머진 받은대로 그대로 주고 drinkidx만 바꿔 주면 될듯함
	 * @param menuidx
	 * @param set
	 * @param setidx
	 * @param sideidx
	 * @param drinkidx
	 */
	public void veiw_Select_Drink(int menuidx, String  set, int setidx, int sideidx, int drinkidx, int cartidx) {
		ManagerCP.reFresh(panel);
		panel.add(new kiosk7(this, menuidx, set, setidx, sideidx, drinkidx, cartidx));
	}
	
	/**
	 * 세트, 사이드, 음료 다 고르고 카트담기를 눌렀을 때 -> 형래님 홈 화면으로
	 * 이때 형래님이 필요한 정보들 상의해서 추가 (줄수있는 정보 : 햄버거번호, 세트번호, 음료번호, 사이드번호, 각자 가격, 총 가격)
	 * @param menuidx 임시로 햄버거 idx 추가함
	 */
//	public void veiw_Home_set_burger(int menuidx) {
//		ManagerCP.reFresh(panel);
//		//panel.add(new HomeMenuKiosk(this,menuidx));
//	}
	
	public Set_Option(HomeMenuKiosk hMain, int idx, String set) {
		this.hMain = hMain;
		panel = new JPanel();
		add(panel);
		Logo_MenuName_Panel logo = new Logo_MenuName_Panel(idx, "o");
		panel.add(logo);
		
		Select_Set_down selSet = new Select_Set_down(hMain, idx, this);
		panel.add(selSet);
		panel.setLayout(null);
		panel.setBounds(0,0,900,1040);
		
		setLayout(null);
		setTitle("Da팔아");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
}

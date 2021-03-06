package kioske.YounukLee7;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.model.PsList;
import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.YounukLee7.kioskeUI.Card_Pay_mid;
import kioske.YounukLee7.kioskeUI.Completed_up;
import kioske.YounukLee7.kioskeUI.Down_yes_no_Button;
import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Mobile_Pay_mid;
import kioske.YounukLee7.kioskeUI.Order_completed_down;
import kioske.YounukLee7.kioskeUI.Payment_up;
import kioske.YounukLee7.kioskeUI.Select_Payment_down;
import kioske.YounukLee7.kioskeUI.Select_Payment_mid;
import kioske.YounukLee7.kioskeUI.Select_Set_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.ui.MainPanel;
import kioske.pherkad0602.ui.PayPanel;
import manager.component.ManagerCP;

public class Main_JFrame extends JFrame{
	
	HomeMenuKiosk hMain;
	Main_JPanel panel;
	MainPanel main;
	PayPanel pay;
	//public ArrayList orderList;
	public ArrayList<Order_list> orderList;
	
	/**
	 * 첫 화면에서 -> 포장 선택 화면으로
	 */
	public void veiw_takeout() {
		ManagerCP.reFresh(panel);
		panel.add(new Select_Takeout_up());
		panel.add(new Select_Takeout_down(this));
	}
	
	/**
	 * 포장 선택 화면에서 -> 형래님 홈 화면으로 (idx에 줄 값이 없어 0으로 줌) 
	 */
	public void veiw_Home() {
		ManagerCP.reFresh(panel);
		panel.add(new HomeMenuKiosk(this,0));
	}
	
	/**
	 * 형래님 홈 화면에서 햄버거 눌렀을 때 -> 단품, 세트 화면으로
	 * @param menuidx 햄버거 매뉴IDX
	 * 
	 */
//	public void veiw_Select_Set(int menuidx) {
//		ManagerCP.reFresh(panel);
//	//	hMain.setVisible(false);
//		panel.add(new Logo_MenuName_Panel(menuidx, null));
//		panel.add(new Select_Set_down(this, menuidx));
//	}
	
	/**
	 * 단품, 세트 화면에서 단품 눌렀을 때 -> 형래님 홈 화면으로 (menuidx에 단품 햄버거idx 그대로 줌)
	 */
	public void veiw_Home_solo_burger(int menuidx) {
		ManagerCP.reFresh(panel);
		//hMain.setVisible(true);
		//panel.add(new HomeMenuKiosk(this,menuidx));
		//System.out.println("veiw_Home_solo_burger : " + menuidx);
		hMain.setPrice(menuidx);		
	}
	
	/**
	 * 단품, 세트 화면에서 세트 눌렀을 때 -> 사이드, 음료 변경 카트담기 화면으로 감
	 * @param menuidx 햄버거 menuidx 전달
	 * @param set Logo_MenuName_Panel에 세트로 변경 시 표시해주기 위해 사용
	 * @param setidx menuidx에 setidx 전달
	 * @param sideidx 나중에 사이드 변경 시 이용하기 위해 여기선 0으로 함
	 * @param drinkidx 나중에 음료 변경 시 이용하기 위해 여기선 0으로 함
//	 */
//	public void veiw_Select_Side_Drink(int menuidx, String  set, int setidx, int sideidx, int drinkidx) {
//		ManagerCP.reFresh(panel);
//		panel.add(new Logo_MenuName_Panel(menuidx,set));
//		panel.add(new Select_Side_Drink_down(this, menuidx, setidx, sideidx, drinkidx));
//	}
//	
//	/**
//	 * 미구현 - 바로 위에 사이드, 음료 변경 카트담기 화면에서 사이드변경 클릭 시 -> 사이드변경 화면으로 감
//	 * 나머진 받은대로 그대로 주고 sideidx만 바꿔 주면 될듯함
//	 * @param menuidx
//	 * @param set
//	 * @param setidx
//	 * @param sideidx - 0이 들어있을 예정
//	 * @param drinkidx
//	 */
//	public void veiw_Select_Side(int menuidx, String  set, int setidx, int sideidx, int drinkidx, int cartidx) {
//		ManagerCP.reFresh(panel);
//		panel.add(new kiosk7(this, menuidx, set, setidx, sideidx, drinkidx, cartidx));
//	}
//	
//	/**
//	 * 미구현 - 바로 위에 사이드, 음료 변경 카트담기 화면에서 음료변경 클릭 시 -> 음료변경 화면으로 감
//	 * 나머진 받은대로 그대로 주고 drinkidx만 바꿔 주면 될듯함
//	 * @param menuidx
//	 * @param set
//	 * @param setidx
//	 * @param sideidx
//	 * @param drinkidx
//	 */
//	public void veiw_Select_Drink(int menuidx, String  set, int setidx, int sideidx, int drinkidx, int cartidx) {
//		ManagerCP.reFresh(panel);
//		panel.add(new kiosk7(this, menuidx, set, setidx, sideidx, drinkidx, cartidx));
//	}
//	
	/**
	 * 세트, 사이드, 음료 다 고르고 카트담기를 눌렀을 때 -> 형래님 홈 화면으로
	 * 이때 형래님이 필요한 정보들 상의해서 추가 (줄수있는 정보 : 햄버거번호, 세트번호, 음료번호, 사이드번호, 각자 가격, 총 가격)
	 * @param menuidx 임시로 햄버거 idx 추가함
	 */
//	public void veiw_Home_set_burger(int menuidx) {
//		ManagerCP.reFresh(panel);
//		panel.add(new HomeMenuKiosk(this,menuidx));
//	}
	
	/**
	 * 홈 화면에서 주문내역 클릭 시 -> 최종주문창으로 이동
	 */
	public void veiw_Final_payment() {
		ManagerCP.reFresh(panel);
		panel.add(new Last_JPanel(this, hMain));
	}
	
	// 최종주문창에서 주문완료 선택 시 -> 결제 선택 화면으로 이동
	public void veiw_Select_Payment() {
		// 여기서부터 frame 끝가지 가지고 가야합니다
		ManagerCP.reFresh(panel);
		panel.add(new Payment_up());
		panel.add(new Select_Payment_mid(this));
		panel.add(new Select_Payment_down(this));
	}
	
	public void veiw_Card_Pay(String card) {
		ManagerCP.reFresh(panel);
		panel.add(new Payment_up());
		panel.add(new Card_Pay_mid());
		panel.add(new Down_yes_no_Button(this,card));
	}
	
	public void veiw_Mobile_Pay(String mobile) {
		ManagerCP.reFresh(panel);
		panel.add(new Payment_up());
		panel.add(new Mobile_Pay_mid());
		panel.add(new Down_yes_no_Button(this,mobile));
	}
	
	public void veiw_Order_completed() {
		ManagerCP.reFresh(panel);
		panel.add(new Completed_up());
		panel.add(new Order_completed_down(this));
	}
	
	public void veiw_back_first_screen() {
		ManagerCP.reFresh(panel);
		panel.add(new Main_JPanel(this));
	}

	public Main_JFrame() {
		hMain = new HomeMenuKiosk();
		orderList = new ArrayList<>();
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

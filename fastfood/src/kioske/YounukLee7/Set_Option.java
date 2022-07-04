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
	 * �̱��� - �ٷ� ���� ���̵�, ���� ���� īƮ��� ȭ�鿡�� ���̵庯�� Ŭ�� �� -> ���̵庯�� ȭ������ ��
	 * ������ ������� �״�� �ְ� sideidx�� �ٲ� �ָ� �ɵ���
	 * @param menuidx
	 * @param set
	 * @param setidx
	 * @param sideidx - 0�� ������� ����
	 * @param drinkidx
	 */
	public void veiw_Select_Side(int menuidx, String  set, int setidx, int sideidx, int drinkidx, int cartidx) {
		ManagerCP.reFresh(panel);
		panel.add(new kiosk7(this, menuidx, set, setidx, sideidx, drinkidx, cartidx));
	}
	
	/**
	 * �̱��� - �ٷ� ���� ���̵�, ���� ���� īƮ��� ȭ�鿡�� ���ắ�� Ŭ�� �� -> ���ắ�� ȭ������ ��
	 * ������ ������� �״�� �ְ� drinkidx�� �ٲ� �ָ� �ɵ���
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
	 * ��Ʈ, ���̵�, ���� �� ���� īƮ��⸦ ������ �� -> ������ Ȩ ȭ������
	 * �̶� �������� �ʿ��� ������ �����ؼ� �߰� (�ټ��ִ� ���� : �ܹ��Ź�ȣ, ��Ʈ��ȣ, �����ȣ, ���̵��ȣ, ���� ����, �� ����)
	 * @param menuidx �ӽ÷� �ܹ��� idx �߰���
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
		setTitle("Da�Ⱦ�");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
}

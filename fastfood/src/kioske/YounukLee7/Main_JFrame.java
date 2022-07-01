package kioske.YounukLee7;


import javax.swing.JFrame;
import javax.swing.JPanel;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_down;
import kioske.YounukLee7.kioskeUI.Select_Takeout_up;
import kioske.YounukLee7.kioskeUI.Start_Screen_kiosk;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import manager.component.ManagerCP;

public class Main_JFrame extends JFrame{
	
	Main_JPanel panel;
	
	
	/**
	 * ù ȭ�鿡�� -> ���� ���� ȭ������
	 */
	public void veiw_takeout() {
		ManagerCP.reFresh(panel);
		panel.add(new Select_Takeout_up());
		panel.add(new Select_Takeout_down(this));
	}
	
	/**
	 * ���� ���� ȭ�鿡�� -> ������ Ȩ ȭ������ (idx�� �� ���� ���� 0���� ��) 
	 */
	public void veiw_Home() {
		ManagerCP.reFresh(panel);
		panel.add(new HomeMenuKiosk(this,0));
	}
	
	/**
	 * ������ Ȩ ȭ�鿡�� �ܹ��� ������ �� -> ��ǰ, ��Ʈ ȭ������
	 * @param menuidx �ܹ��� �Ŵ�IDX
	 * 
	 */
	public void veiw_Select_Set(int menuidx) {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel(menuidx, null));
		panel.add(new Select_Set_down(this, menuidx));
	}
	
	/**
	 * ��ǰ, ��Ʈ ȭ�鿡�� ��ǰ ������ �� -> ������ Ȩ ȭ������ (menuidx�� ��ǰ �ܹ���idx �״�� ��)
	 */
	public void veiw_Home_solo_burger(int menuidx) {
		ManagerCP.reFresh(panel);
		panel.add(new HomeMenuKiosk(this,menuidx));
	}
	
	/**
	 * ��ǰ, ��Ʈ ȭ�鿡�� ��Ʈ ������ �� -> ���̵�, ���� ���� īƮ��� ȭ������ ��
	 * @param menuidx �ܹ��� menuidx ����
	 * @param set Logo_MenuName_Panel�� ��Ʈ�� ���� �� ǥ�����ֱ� ���� ���
	 * @param setidx menuidx�� setidx ����
	 * @param sideidx ���߿� ���̵� ���� �� �̿��ϱ� ���� ���⼱ 0���� ��
	 * @param drinkidx ���߿� ���� ���� �� �̿��ϱ� ���� ���⼱ 0���� ��
	 */
	public void veiw_Select_Side_Drink(int menuidx, String  set, int setidx, int sideidx, int drinkidx) {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel(menuidx,set));
		panel.add(new Select_Side_Drink_down(this, menuidx, setidx, sideidx, drinkidx));
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
	public void veiw_Home_set_burger(int menuidx) {
		ManagerCP.reFresh(panel);
		panel.add(new HomeMenuKiosk(this,menuidx));
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

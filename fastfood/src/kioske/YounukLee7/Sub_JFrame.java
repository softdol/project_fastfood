package kioske.YounukLee7;

import javax.swing.JFrame;

import kioske.YounukLee7.kioskeUI.Logo_MenuName_Panel;
import kioske.YounukLee7.kioskeUI.Select_Set_Size_down;
import kioske.YounukLee7.kioskeUI.Select_Side_Drink_down;
import manager.component.ManagerCP;

public class Sub_JFrame extends JFrame {
	
	Sub_JPanel panel;
	
	// ��ǰ,��Ʈ �� ��Ʈ ���� �� ������Ʈ ���� ȭ������ ��
	public void veiw_Set_Size(int idx, String  set) {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel(idx,set));
		panel.add(new Select_Set_Size_down(this, idx));
	}
	
	public void veiw_Select_Side_Drink(int idx, String  set, int setidx) {
		ManagerCP.reFresh(panel);
		panel.add(new Logo_MenuName_Panel(idx,set));
		panel.add(new Select_Side_Drink_down(idx,setidx,3,0));
	}
	
	public Sub_JFrame() {
		
		panel = new Sub_JPanel(this,1);
		add(panel);
		
		setLayout(null);
		setTitle("Da�Ⱦ�");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Sub_JFrame();
	}
}

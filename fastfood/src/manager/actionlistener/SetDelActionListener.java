package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.menu.MenuSetModify;

public class SetDelActionListener implements ActionListener {

	private MenuSetModify modMain;
	private int idx;
	private char tAction;
	
	public SetDelActionListener(MenuSetModify modMain, int idx, char tAction) {
		this.modMain = modMain;
		this.idx = idx;
		this.tAction = tAction;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(tAction) {
			case 'D':	// ��� ����
				modMain.delSetMenu(idx);
				break;
			
			case 'P':	// ��� �߰�
				modMain.addSetMenu();
				break;
				
			case 'I':	// db insert
				modMain.insSetMenu();
				break;
			
		}
		
	}

}

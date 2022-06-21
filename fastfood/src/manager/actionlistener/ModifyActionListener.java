package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.ManagerMain;

public class ModifyActionListener implements ActionListener {
	
	ManagerMain main;
	private String pName;
	private int idx;
	
	public ModifyActionListener(ManagerMain main, String pName, int idx) {
		this.main = main;
		this.pName = pName;
		this.idx = idx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.viewModifyPanel(pName, idx);
	}

}

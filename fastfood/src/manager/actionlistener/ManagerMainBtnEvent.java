package manager.actionlistener;

import java.awt.event.ActionListener;

import manager.ManagerMain;

abstract public class ManagerMainBtnEvent implements ActionListener {
	
	ManagerMain main;
	
	public ManagerMainBtnEvent(ManagerMain main) {
		this.main = main;
	}

}

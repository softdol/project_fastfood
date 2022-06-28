package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.sales.SalesMain;

public class SalesTopMonthActionListener implements ActionListener {

	SalesMain sMain;
	String sCate;
	
	public SalesTopMonthActionListener(SalesMain sMain, String sCate) {
		this.sMain = sMain;
		this.sCate = sCate;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sMain.setOpenClose(sCate);
	}

}

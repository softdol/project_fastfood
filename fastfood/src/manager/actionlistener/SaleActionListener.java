package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.sales.SalesMain;

public class SaleActionListener implements ActionListener {

	SalesMain sMain;
	String strEvene;
	
	public SaleActionListener(SalesMain sMain, String strEvene) {
		this.sMain = sMain;
		this.strEvene = strEvene;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sMain.chgCalendar(strEvene);
	}

}

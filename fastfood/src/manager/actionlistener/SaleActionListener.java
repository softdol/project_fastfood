package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.sales.SalesGraphView;
import manager.sales.SalesMain;

public class SaleActionListener implements ActionListener {

	SalesMain sMain;
	SalesGraphView gMain;
	String strEvene;
	
	public SaleActionListener(SalesMain sMain, String strEvene) {
		this.sMain = sMain;
		this.strEvene = strEvene;
	}
	
	public SaleActionListener(SalesGraphView gMain, String strEvene) {
		this.gMain = gMain;
		this.strEvene = strEvene;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(strEvene.length() == 3) {
			gMain.chgCalendar(strEvene);
		}else {
			sMain.chgCalendar(strEvene);
		}
		
	}

}

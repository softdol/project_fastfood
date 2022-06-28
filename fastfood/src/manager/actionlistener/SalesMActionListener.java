package manager.actionlistener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import database.manager.Calculate;
import manager.sales.SalesMain;

public class SalesMActionListener implements MouseListener {
	
	private SalesMain sMain;
	Calculate calculate;
	int idx;
	
	public SalesMActionListener(SalesMain sMain, Calculate calculate, int idx) {
		this.sMain = sMain;
		this.calculate = calculate;
		this.idx = idx;
	};

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		sMain.selDay(calculate, idx);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}

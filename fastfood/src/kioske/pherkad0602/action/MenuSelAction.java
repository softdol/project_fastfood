package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;

public class MenuSelAction implements ActionListener {
	
	HomeMenuKiosk hMain;
	Main_JFrame frame;
	int idx;
	
	public MenuSelAction(HomeMenuKiosk hMain, int idx, Main_JFrame frame) {
		this.hMain = hMain;
		this.frame = frame;
		this.idx = idx;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		hMain.order(idx);
	}

}

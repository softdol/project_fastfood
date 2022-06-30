package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.ui.OrderCheck;

public class MenuChangeAction implements ActionListener{
	HomeMenuKiosk hMain;
	public MenuChangeAction(HomeMenuKiosk hMain, int idx1, int idx2) {
		this.hMain = hMain;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(1);
		hMain.setPrice(1);
	}
	
           
 }
	


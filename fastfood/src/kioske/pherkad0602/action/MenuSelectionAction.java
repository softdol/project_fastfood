package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.ui.OrderCheck;

public class MenuSelectionAction implements ActionListener{
	HomeMenuKiosk hMain;
	public MenuSelectionAction(HomeMenuKiosk hMain) {
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
	


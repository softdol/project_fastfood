package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import kioske.pherkad0602.ui.OrderCheck;

public class MenuChangeAction implements ActionListener{
	kiosk7  kiosk7;
	int idx;
	int addCost;
	Main_JFrame frame;
	
	public MenuChangeAction	(Main_JFrame frame, kiosk7 kiosk7, int idx, int addCost) {
		this.kiosk7 = kiosk7;
		this.idx = idx;
		this.addCost = addCost;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		kiosk7.setPrice(frame, kiosk7, idx, addCost);
	}
	
           
 }
	


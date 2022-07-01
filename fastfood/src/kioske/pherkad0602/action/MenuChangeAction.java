package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.SetDatabase;
import kioske.pherkad0602.ui.OrderCheck;

public class MenuChangeAction implements ActionListener{
	kiosk7  kiosk7;
	Main_JFrame frame;
	int idx;
	int addCost;
	int menuidx;
	String set;
	int setidx;
	int sideidx;
	int drinkidx;
	int catei;
	
	public MenuChangeAction	(Main_JFrame frame, int menuidx, String  set, int setidx, int sideidx, int drinkidx, int catei
			,kiosk7 kiosk7, int idx, int addCost) {
		this.kiosk7 = kiosk7;
		this.idx = idx;
		this.addCost = addCost;
		this.frame = frame;
		this.menuidx = menuidx;
		this.set = set;
		this.setidx = setidx;
		this.sideidx = sideidx;
		this.drinkidx = drinkidx;
		this.catei = catei;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		kiosk7.setPrice(frame, menuidx, set, setidx, sideidx, drinkidx, catei, kiosk7,idx, addCost);
	}
	
           
 }
	


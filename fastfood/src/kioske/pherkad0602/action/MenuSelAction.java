package kioske.pherkad0602.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class MenuSelAction implements ActionListener {
	
	HomeMenuKiosk hMain;
	Main_JFrame frame;
	MenuDatabase menu;
	
	public MenuSelAction(HomeMenuKiosk hMain, MenuDatabase menu, Main_JFrame frame) {
		this.hMain = hMain;
		this.frame = frame;
		this.menu = menu;
		// TODO Auto-generated constructor stub
	}
	
	public MenuSelAction(HomeMenuKiosk hMain, int idx, Main_JFrame frame) {
		this.hMain = hMain;
		this.frame = frame;
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu where menu_idx = ?";
	  	psList.add(new PsList('I', String.valueOf(idx)));
	  	this.menu = ReturnModel.menuList(sql, psList);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		hMain.order(menu, frame);
	}

}

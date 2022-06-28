package kioske.pherkad0602.ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.SubMenuDatabase;

public class MenuPanel extends JPanel{
	
	HomeMenuKiosk hMain;
	
	public MenuPanel(ArrayList<SubMenuDatabase> sList1, ArrayList<MenuDatabase> menuList, HomeMenuKiosk hMain, int i){
		EmptyBorder border = new EmptyBorder(getInsets());
		this.hMain = hMain;

		SubMenuPanel sub = new SubMenuPanel(sList1, hMain);
		add(sub);
		
		MenuNamePanel mName = new MenuNamePanel(i, sList1);
		add(mName);
		
		MainMenuPanel main = new MainMenuPanel(menuList);
		add(main);
		

		setBounds(200, 0, 884, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);

	}



}

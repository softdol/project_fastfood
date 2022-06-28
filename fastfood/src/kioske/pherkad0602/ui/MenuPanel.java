package kioske.pherkad0602.ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.database.SubMenuDatabase;

public class MenuPanel extends JPanel{

	public MenuPanel(ArrayList<SubMenuDatabase> sList){
		EmptyBorder border = new EmptyBorder(getInsets());
		
		//JPanel mainPanel = new JPanel();
		//add(mainPanel);
		
		SubMenuPanel sub = new SubMenuPanel(sList);
		add(sub);
		
		MenuNamePanel mName = new MenuNamePanel();
//		add(mName.MenuNamePanel(1));
		
		MainMenuPanel main = new MainMenuPanel();
		//add(main.MainMenuPanel(sql1));
		

		setBounds(200, 0, 884, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);

	}



}

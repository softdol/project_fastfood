package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPanel extends JPanel{

	public Component MenuPanel(String sql1, String sql2){
		EmptyBorder border = new EmptyBorder(getInsets());
		
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		
		SubMenuPanel sub = new SubMenuPanel();
		mainPanel.add(sub.SubMenuPanel(sql2));
		
		MenuNamePanel mName = new MenuNamePanel();
		mainPanel.add(mName.MenuNamePanel(1));
		
		MainMenuPanel main = new MainMenuPanel();
		mainPanel.add(main.MainMenuPanel(sql1));
		

		mainPanel.setBounds(200, 0, 884, 800);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		return mainPanel;
	}



}

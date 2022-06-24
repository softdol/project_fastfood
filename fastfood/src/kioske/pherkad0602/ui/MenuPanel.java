package kioske.pherkad0602.ui;

import java.awt.Component;

import javax.swing.JPanel;

public class MenuPanel extends JPanel{

	public Component MenuPanel(String sql1, String sql2){
		
		JPanel mainPanel = new JPanel();

		add(mainPanel);
		
		
		SubMenuPanel sub = new SubMenuPanel();
		mainPanel.add(sub.SubMenuPanel(sql2));
		
		MenuNamePanel mName = new MenuNamePanel();
		mainPanel.add(mName.MenuNamePanel());
		
		MainMenuPanel main = new MainMenuPanel();
		mainPanel.add(main.MainMenuPanel(sql1));
		

		mainPanel.setBounds(200, 0, 884, 800);
		mainPanel.setLayout(null);
		
		return mainPanel;
	}



}

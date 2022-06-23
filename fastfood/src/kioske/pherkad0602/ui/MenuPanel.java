package kioske.pherkad0602.ui;

import java.awt.Component;

import javax.swing.JPanel;

public class MenuPanel extends JPanel{

	public Component MenuPanel(){
		
		JPanel mainPanel = new JPanel();

		add(mainPanel);
		
		String[] subMenu = {"비프","치킨","씨푸드"};// db받아오기
		
		SubMenuPanel sub = new SubMenuPanel();
		mainPanel.add(sub.SubMenuPanel(subMenu));
		
		MenuNamePanel mName = new MenuNamePanel();
		mainPanel.add(mName.MenuNamePanel());
		
		MainMenuPanel main = new MainMenuPanel();
		mainPanel.add(main.MainMenuPanel());
		

		mainPanel.setBounds(200, 0, 884, 800);
		mainPanel.setLayout(null);
		
		return mainPanel;
	}



}

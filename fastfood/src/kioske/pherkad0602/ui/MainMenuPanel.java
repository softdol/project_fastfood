package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainMenuPanel extends JPanel{
	
	public Component MainMenuPanel(String sql) {
		
		int a = MenuDatabase.size(sql);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 200, 684, 600);
		menuPanel.setLayout(null);
		
		Menu menu= new Menu();
		menuPanel.add(menu.Menu(sql));	
		
		JScrollPane scrollPane = new JScrollPane(menuPanel);
		scrollPane.setBounds(0, 200, 684, 600);
		Dimension size = new Dimension();
				size.setSize(600,200+(200*(a/3)+1));
		menuPanel.setPreferredSize(size);
		
		
		return scrollPane;
	}
	
	
}

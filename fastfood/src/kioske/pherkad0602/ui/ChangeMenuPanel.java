package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.database.MenuDatabase;

public class ChangeMenuPanel extends JPanel {
	
	public ChangeMenuPanel (ArrayList<MenuDatabase> sList) {
		
		EmptyBorder border = new EmptyBorder(getInsets());
		int a = sList.size();
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 200, 684, 600);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBorder(border);
		
		Menu menu= new Menu(sql);
		menuPanel.add(menu);	
		
		JScrollPane scrollPane = new JScrollPane(menuPanel);
		scrollPane.setBounds(100, 100, 684, 440);
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,200+(200*(a/3)+1));
		menuPanel.setPreferredSize(size);
		
		
		
	}
	
}

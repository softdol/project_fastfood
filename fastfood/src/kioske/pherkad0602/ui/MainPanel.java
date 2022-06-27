package kioske.pherkad0602.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel{
	
	public Component MainPanel() {
		
		CardLayout cardLayoutManager = new CardLayout();
		
		EmptyBorder border = new EmptyBorder(getInsets());
		
		String sql1 = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
		String sql2 = "SELECT * FROM Menu_subcategory WHERE menu_category_IDX = 1";
		
		
		JPanel mainPanel = new JPanel();
		
		HomePanel home = new HomePanel();		
		mainPanel.add("home",home.HomePanel());
		
		MenuPanel menu = new MenuPanel();
		add("menu1",menu.MenuPanel(sql1,sql2));
		
		
		mainPanel.setBounds(200, 0, 684, 800);
		mainPanel.setLayout(cardLayoutManager);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		return mainPanel;
	}
	
	
}

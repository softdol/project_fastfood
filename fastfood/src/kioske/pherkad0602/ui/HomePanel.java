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
import javax.swing.border.EmptyBorder;

public class HomePanel extends JPanel{

	public Component HomePanel() {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		LayoutManager manager = new GridLayout(4, 3);
		
		JPanel mainPanel = new JPanel();
		
		int a = MenuDatabase.size("SELECT * FROM Menu WHERE Menu_Category_IDX = 1");
		
		mainPanel.setBounds(200, 0, 684, 800);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		SmallEventBanner seb = new SmallEventBanner();
		for(int i = 0; i <3; ++i) {
			mainPanel.add(seb.SmallEventBanner(i));
		}
		
		JPanel titlePanel = new JPanel();
		
		titlePanel.setBounds(0, 450, 684, 100);
		titlePanel.setLayout(null);
		titlePanel.setBackground(Color.white);
		titlePanel.setBorder(border);
		
		JLabel title = new JLabel(" 인기 메뉴");
		
		title.setBounds(20,10,500,80);
		title.setBackground(Color.white);
		title.setFont(new Font("궁서체", Font.PLAIN,40));
		titlePanel.add(title);
		
		mainPanel.add(titlePanel);
		
		Menu menu= new Menu();
		
		mainPanel.add(menu.Menu());
		
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(200, 0, 684, 800);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,550+(200*(a/3)+1));
		mainPanel.setPreferredSize(size);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
	
		
		return scrollPane;
	}

}

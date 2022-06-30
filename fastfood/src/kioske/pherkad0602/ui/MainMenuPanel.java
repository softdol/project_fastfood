package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class MainMenuPanel extends JPanel{
	
	public  MainMenuPanel(ArrayList<MenuDatabase> menuList, HomeMenuKiosk hMain, Main_JFrame frame) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		int a = menuList.size();
		
		JPanel mainPanel = new JPanel();
		
		mainPanel.setBounds(0, 200, 684, 600);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		Menu menu= new Menu(menuList, hMain, frame);
		mainPanel.add(menu);	
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(0, 0, 684, 600);
		scrollPane.setBackground(Color.white);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,(210*((a-1)/3)+1));
		mainPanel.setPreferredSize(size);
		add(scrollPane);
	
		System.out.println(a);
		
		setBounds(0, 200, 684, 600);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
	}
	
	
}

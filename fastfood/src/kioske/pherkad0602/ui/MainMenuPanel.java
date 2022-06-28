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

import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class MainMenuPanel extends JPanel{
	
	public  MainMenuPanel(ArrayList<MenuDatabase> menuList) {
		EmptyBorder border = new EmptyBorder(getInsets());
		

		int a = menuList.size();
		
		
		setBounds(0, 200, 684, 600);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
		Menu menu= new Menu(menuList);
		add(menu);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 200, 684, 600);
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,200+(200*(a/3)+1));
		setPreferredSize(size);
		
		
	}
	
	
}

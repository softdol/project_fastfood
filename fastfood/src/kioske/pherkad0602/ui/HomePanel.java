package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.model.PsList;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class HomePanel extends JPanel{

	public  HomePanel(HomeMenuKiosk hMain) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		
		JPanel mainPanel = new JPanel();
		String sql = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
		ArrayList<MenuDatabase> menuList = ReturnModel.menuList(sql);
		
		int a = menuList.size();
		
		mainPanel.setBounds(0, 0, 684, 800);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		SmallEventBanner seb = new SmallEventBanner();
	
		for(int i = 0; i <3; ++i) {
			
			mainPanel.add(seb.SmallEventBanner(hMain,i));
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
		titlePanel.setBorder(border);
		titlePanel.add(title);
		
		mainPanel.add(titlePanel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBorder(border);
		
		
		Menu menu= new Menu(menuList, hMain);
		menuPanel.add(menu);
		menuPanel.setBounds(0,550,684,550+(200*(a/3)+1));
		mainPanel.add(menuPanel);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(0, 0, 684, 800);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,550+(200*(a/3)+1));
		mainPanel.setPreferredSize(size);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
		add(scrollPane);
		setBounds(0, 200, 684, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
	}

}

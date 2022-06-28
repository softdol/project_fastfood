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
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class HomePanel extends JPanel{

	public  HomePanel() {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		
		JPanel mainPanel = new JPanel();
		String sql = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
		
		ArrayList<MenuDatabase> sList = new ArrayList<>();
		ArrayList<PsList> psList = new ArrayList<>();
		
		for(int i = 0; i < sList.size() ; i++) {

		psList.add(new PsList('S', String.valueOf(sList.get(i).getImg_big_path())));
		psList.add(new PsList('S', String.valueOf(sList.get(i).getMenu_name())));
		psList.add(new PsList('I', String.valueOf(sList.get(i).getMenu_idx())));
		}
		//sList = ReturnModel.selMenuList1(sql, psList);
		
		int a = sList.size();
		
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
		titlePanel.setBorder(border);
		titlePanel.add(title);
		
		mainPanel.add(titlePanel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 450, 684, 100);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBorder(border);
		
		
		Menu menu= new Menu(sList);
		menuPanel.add(menu);
		menuPanel.setBounds(0,550,684,550+(200*(a/3)+1));
		mainPanel.add(menuPanel);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(200, 0, 684, 800);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,550+(200*(a/3)+1));
		mainPanel.setPreferredSize(size);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
		
	}

}

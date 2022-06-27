package kioske.pherkad0602.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel{
	public static CardLayout cardLayoutManager = new CardLayout();
	public static JPanel mainPanel = new JPanel();

	public Component MainPanel() {
		
		EmptyBorder border = new EmptyBorder(getInsets());
		
		String sql = "SELECT * FROM Menu_subcategory";
		
		ArrayList name = SubMenuDatabase.subMenuNameArray(sql);
		ArrayList cateIdx = SubMenuDatabase.menuCategoryIdxArray(sql); 
		
		HomePanel home = new HomePanel();		
		mainPanel.add("home",home.HomePanel());
		
		for(int i = 1; i <4 ; i++) {
			
			String j = String.valueOf(cateIdx.get(i));
			
			String sql1 = "SELECT * FROM Menu WHERE Menu_Category_IDX = " + i;
			String sql2 = "SELECT * FROM Menu_subcategory WHERE menu_category_IDX = " + j;
	
			MenuPanel menu = new MenuPanel();
			mainPanel.add(String.valueOf(name.get(i)),menu.MenuPanel(sql1,sql2));
		
		}
		
		
		mainPanel.setBounds(200, 0, 684, 800);
		mainPanel.setLayout(cardLayoutManager);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		return mainPanel;
	}
	
	
}

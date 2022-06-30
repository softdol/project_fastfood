package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.model.PsList;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class ChangeMenuPanel extends JPanel {
	
	public ChangeMenuPanel (int idx, int i) {
		
		ArrayList<PsList> psList = new ArrayList<>();
		String sql = "select * from menu where MENU_CATEGORY_IDX = ?";
		psList.add(new PsList('I', String.valueOf(i)));
		ArrayList<MenuDatabase> menuList = ReturnModel.selMenuList1(sql, psList);
		
		EmptyBorder border = new EmptyBorder(getInsets());
		int a = menuList.size();
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 200, 684, 600);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBorder(border);
		
	//	ChangeMenu menu= new ChangeMenu(menuList, idx);
	//	menuPanel.add(menu);
		
		JScrollPane scrollPane = new JScrollPane(menuPanel);
		scrollPane.setBounds(100, 100, 684, 440);
		scrollPane.setBackground(Color.white);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,200+(210*(a/3)+1));
		menuPanel.setPreferredSize(size);
		
		
		
	}
	
}

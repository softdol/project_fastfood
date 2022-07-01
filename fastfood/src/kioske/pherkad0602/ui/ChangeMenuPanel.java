package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.Set_Option;
import kioske.pherkad0602.kiosk7;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import kioske.pherkad0602.database.SetDatabase;
import manager.menu.MenuList;

public class ChangeMenuPanel extends JPanel {
	
	Set_Option option;
	kiosk7 kiosk7;

	public ChangeMenuPanel (Set_Option option, ArrayList<MenuDatabase> menuList, ArrayList<MenuDatabase> menuInfo,
			ArrayList<SetDatabase> setList, int menuidx, String  set, int setidx, int sideidx, int drinkidx, int catei
			,kiosk7 kiosk7, int final_price) {
		
		EmptyBorder border = new EmptyBorder(getInsets());
		int a = menuList.size();
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 684, 600);
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBorder(border);
		
		ChangeMenu menu= new ChangeMenu(option, menuList, menuInfo, setList, 
				 menuidx, set, setidx, sideidx, drinkidx, catei, kiosk7, final_price);
		menuPanel.add(menu);
		
		JScrollPane scrollPane = new JScrollPane(menuPanel);
		scrollPane.setBounds(0, 0, 684, 440);
		scrollPane.setBackground(Color.white);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,210+(210*(a/3)+1));
		menuPanel.setPreferredSize(size);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
			       scrollPane.getVerticalScrollBar().setValue(0);
			   }
			});
		add(scrollPane);
		
		setBounds(100, 80, 684, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
		
		
	}
	
}

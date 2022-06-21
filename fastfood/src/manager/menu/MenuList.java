package manager.menu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import database.manager.Category;
import database.manager.ReturnModel;
import manager.ManagerMain;
import manager.component.ManagerCP;

public class MenuList extends JPanel {
	
	ManagerMain main;	
    JPanel mainSubList;
    
	public MenuList(ManagerMain main) {
		
		this.main = main;
		
		setLayout(null);
		setBounds(0,0,565,730);
		//setBorder(new LineBorder(Color.BLACK));
		
		JPanel menuCategory = new JPanel();
		
		ArrayList<Category> cataList = ReturnModel.catagoryList();
		
		int cateMax = cataList.size() + 1;
		menuCategory.setLayout(new GridLayout(1, cateMax, 15, 15));
		menuCategory.setBounds(0, 0, 565, 50);
		JButton cateAllBtn = new JButton("ÀüÃ¼");
		menuCategory.add(cateAllBtn);
		cateAllBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewMenuList(0);
			}
		});
		
		for(Category c : cataList) {
			JButton cateBtn = new JButton(c.getMenu_category_name());
			cateBtn.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					viewMenuList(c.getMenu_category_idx());
				}
			});
			menuCategory.add(cateBtn);
		}
		
		mainSubList = new JPanel();
		
		mainSubList.add(new MenuSubList(0));
		
		JScrollPane scPane = new JScrollPane(mainSubList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scPane.getVerticalScrollBar().setUnitIncrement(16);
		
		scPane.setBounds(0,100,565,625);
		
		add(menuCategory);		
		add(scPane);
	}

	public void viewMenuList(int cate) {
		ManagerCP.reFresh(mainSubList);
		mainSubList.add(new MenuSubList(cate));
	}
}

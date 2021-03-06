package manager.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import database.manager.MenuSet;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.ModifyActionListener;
import manager.component.LabelListMenuName;
import manager.component.ManagerCP;

public class MenuSetList extends JPanel {
	
	ManagerMain main;	
    JPanel mainSubList;
	
	public MenuSetList(ManagerMain main) {
		
		this.main = main;
		main.setSize(585,780);
		setLayout(null);
		setBounds(0,0,565,730);
		
		mainSubList = new JPanel();
		
		ArrayList<PsList> psList = new ArrayList<>();
		
		String sql = "select * from menu_set where set_use_flag = 'Y'";
		
		JPanel jpList = new JPanel();
		
		ArrayList<MenuSet> menuList = ReturnModel.selMenuSetList(sql, psList);
				
		int maxItem = Math.max(menuList.size(), 12);
		jpList.setLayout(new GridLayout(maxItem/3 + 1, 3, 15, 15));
		
		for(int i  = 0; i < maxItem; i++) {
			
			if(i < menuList.size()) {
				MenuSet m = menuList.get(i);
				
				ImageIcon icon = new ImageIcon(m.getSet_img_path());
				Image img = icon.getImage();
				Image cimg = img.getScaledInstance(130,200,img.SCALE_SMOOTH);
				
				JButton btn = new JButton(new ImageIcon(cimg));
				btn.addActionListener(new ModifyActionListener(main,"세트메뉴수정",m.getSet_idx()));
				btn.setPreferredSize(new Dimension(140, 200));
				
				LabelListMenuName jlName = new LabelListMenuName(m.getSet_name());
				
				btn.setLayout(new BorderLayout());
				btn.add(jlName, BorderLayout.NORTH);
				
				jpList.add(btn);
			}else {
				JButton btn = new JButton("준비중");
				btn.setPreferredSize(new Dimension(140, 200));
				
				jpList.add(btn);
			}
		}
		
		mainSubList.add(jpList);
		
		JScrollPane scPane = new JScrollPane(mainSubList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scPane.getVerticalScrollBar().setUnitIncrement(16);
		
		scPane.setBounds(0,0,565,705);
			
		add(scPane);
		
	}
	
	public void viewMenuList(int cate) {
		ManagerCP.reFresh(mainSubList);
		mainSubList.add(new MenuSubList(main, cate));
	}
	
}

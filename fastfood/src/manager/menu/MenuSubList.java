package manager.menu;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;

public class MenuSubList extends JPanel {

	public MenuSubList(int cate) {
		
		ArrayList<PsList> psList = new ArrayList<>();
		
		String sql = "select * from menu";
		
		if(cate > 0) {
			sql += " where MENU_CATEGORY_IDX = ?";
			psList.add(new PsList('I', String.valueOf(cate)));
		}
		
		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
				
		int maxItem = Math.max(menuList.size(), 12);
		setLayout(new GridLayout(maxItem/3 + 1, 3, 15, 15));
		
		for(int i  = 0; i < maxItem; i++) {
			
			if(i < menuList.size()) {
				Menu m = menuList.get(i);
				
				ImageIcon icon = new ImageIcon(m.getImg_big_path());
				Image img = icon.getImage();
				Image cimg = img.getScaledInstance(130,200,img.SCALE_SMOOTH);
				
				JButton btn = new JButton(new ImageIcon(cimg));
				
				add(btn);
			}else {
				JButton btn = new JButton("ÁØºñÁß");
				btn.setSize(130,200);
				
				add(btn);
			}
		}
		
		
		
	}	
	
}

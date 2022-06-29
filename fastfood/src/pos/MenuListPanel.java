package pos;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;

public class MenuListPanel extends JPanel{
	
	public MenuListPanel(int iCate) {
		
		setBackground(new Color(0xD9EDDF));
		setBounds(400,120,455,460);
		
		String sql = "select * from menu where menu_category_idx = ?";
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('I', String.valueOf(iCate)));
		
		
		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
		
		int maxItem = Math.max(menuList.size(), 12);
		setLayout(new GridLayout(maxItem/3 + 1, 3));
		
		for(int i  = 0; i < maxItem; i++) {
			
			if(i < menuList.size()) {
				Menu m = menuList.get(i);
				
				JButton itemBtn = new JButton();
				itemBtn.setBounds(10, 10, 10, 10);
				itemBtn.setText(m.getMenu_name());
				add(itemBtn);
				
			}else {
				JButton itemBtn = new JButton();
				itemBtn.setBounds(10, 10, 10, 10);
				itemBtn.setText("ÁØºñÁß");
				add(itemBtn);
			}
		}
		
	}

}

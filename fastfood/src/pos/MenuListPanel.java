
package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;
import pos.ActionListener.ButtonActionListener;

public class MenuListPanel extends JPanel{
	Pos_Burger main;
	
	public MenuListPanel(int iCate,Pos_Burger main) {
		this.main = main;
		setBackground(new Color(0xD9EDDF));
		setBounds(400,120,455,460);
		
		String sql = "select * from menu where menu_use_flag = 'Y' AND menu_category_idx = ?";
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('I', String.valueOf(iCate)));
		
		
		ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
		JButton itemBtn;
		
		int maxItem = Math.max(menuList.size(), 12);
		setLayout(new GridLayout(maxItem/3 + 1, 3));
		
		for(int i  = 0; i < maxItem; i++) {
			
			if(i < menuList.size()) {
				Menu m = menuList.get(i);
				
				itemBtn = new JButton();
				itemBtn.setBounds(100, 100, 10, 10);
				itemBtn.setPreferredSize(new Dimension(120, 80));
				itemBtn.setText(m.getMenu_name());
				itemBtn.addActionListener(new ButtonActionListener(main,m));
				add(itemBtn);
			
				
				
			}else {
				itemBtn = new JButton();
				itemBtn.setBounds(100, 100, 10, 10);
				itemBtn.setPreferredSize(new Dimension(120, 80));
				itemBtn.setText("ÁØºñÁß");
				add(itemBtn);
			}
		}
		
		
		
		
		
		
	}


}

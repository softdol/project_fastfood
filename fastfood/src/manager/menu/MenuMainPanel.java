package manager.menu;

import javax.swing.JPanel;

import database.manager.Member;
import manager.ManagerMain;

public class MenuMainPanel extends JPanel{
	
	public JPanel			jpMainMiddle = new JPanel();
		
	public MenuMainPanel(ManagerMain main) {
		setLayout(null);
		setBounds(0,0,1185,730);
		//jpMainMiddle
		
		// 상품 등록
		//menuIns = new MenuInsertPanel(this);
		//add(menuIns);
		
		// 상품 목록
		//menuList = new MenuList(this);
		jpMainMiddle.setLayout(null);
		jpMainMiddle.setBounds(0,0,1185,730);
		jpMainMiddle.add(new MenuList(main));
		//jpMainMiddle.add(new MenuSetInsert(main));
		add(jpMainMiddle);
		
	}
	
	

}

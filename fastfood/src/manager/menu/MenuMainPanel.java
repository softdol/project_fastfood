package manager.menu;

import javax.swing.JPanel;

import manager.ManagerMain;
import manager.member.MemberMain;

public class MenuMainPanel extends JPanel{
	
	public JPanel jpMainMiddle = new JPanel();
		
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
		//jpMainMiddle.add(new MenuInsertPanel(main.mInfo));
		//jpMainMiddle.add(new MenuSetList(main));
		jpMainMiddle.add(new MenuList(main));
		//jpMainMiddle.add(new MenuSetInsert(main));
		//jpMainMiddle.add(new MenuSetModify(main, 1));
		//jpMainMiddle.add(new MemberMain(main));
		
		add(jpMainMiddle);
		
	}
	
	

}

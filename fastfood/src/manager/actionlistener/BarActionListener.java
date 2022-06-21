package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.ManagerMain;
import manager.component.ManagerCP;
import manager.component.bar.BarMenuSubItem;
import manager.menu.MenuInsertPanel;
import manager.menu.MenuList;
import manager.menu.MenuSetInsert;
import manager.menu.MenuSetList;

public class BarActionListener implements ActionListener {
	
	ManagerMain main;
	
	public BarActionListener(ManagerMain main) {
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ManagerCP.reFresh(main.menuMainPanel.jpMainMiddle);
		//System.out.println(main.menuMainPanel.jpMainMiddle.getWidth());		
		//System.out.println(e.getSource());
		BarMenuSubItem thisBtn = (BarMenuSubItem)e.getSource();
//		if(thisBtn.getText().equals("상품등록")) {
//			System.out.println("");
//		}
		switch (thisBtn.getText()) {
			case "상품등록":
				main.menuMainPanel.jpMainMiddle.add(new MenuInsertPanel(main));
			break;
			case "상품목록":
				main.menuMainPanel.jpMainMiddle.add(new MenuList(main));
			break;
			case "셋트메뉴등록":
				main.menuMainPanel.jpMainMiddle.add(new MenuSetInsert(main));
			break;			
			case "셋트메뉴목록":
				main.menuMainPanel.jpMainMiddle.add(new MenuSetInsert(main));
			break;			
			default :
				main.menuMainPanel.jpMainMiddle.add(new MenuSetList(main));
			break;
		}
		
	}

}

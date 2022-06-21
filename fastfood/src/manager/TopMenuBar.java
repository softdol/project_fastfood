package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;

import manager.component.bar.BarActionListener;
import manager.component.bar.BarMenuSubItem;
import manager.component.bar.BarMenuSubTitle;
import manager.component.bar.BarMenuTitle;

public class TopMenuBar extends JMenuBar {
	
	ManagerMain main;
	
	public TopMenuBar(ManagerMain main) {
		
		this.main = main;
		
		BarActionListener barAction = new BarActionListener(main);		
		
		BarMenuTitle menuAll = new BarMenuTitle("메뉴");
		
		BarMenuSubTitle menuTitle = new BarMenuSubTitle("상품관리");		
		BarMenuSubItem menuList = new BarMenuSubItem("상품목록");
		menuList.addActionListener(barAction);
		BarMenuSubItem menuInsert = new BarMenuSubItem("상품등록");
		menuInsert.addActionListener(barAction);
		//menuItem = new JMenuItem(“메뉴항목1”, KeyEvent.VK_T); ->키보드 단축키 설정 가능
		
		menuTitle.add(menuList);
		menuTitle.add(menuInsert);
		
		BarMenuSubItem salesTitle = new BarMenuSubItem("매출조회");
		BarMenuSubItem calculateTitle = new BarMenuSubItem("정산");		
		BarMenuSubItem memberTitle = new BarMenuSubItem("매장관리");		
		
		//openItem.addActionListener(new OpenActionListener());
		menuAll.add(menuTitle);
		menuAll.add(salesTitle);
		menuAll.add(calculateTitle);
		menuAll.add(memberTitle);
		
		JButton menuBanner = new JButton("              로고 이미지");
		menuBanner.setEnabled(false);
		JButton menuOrder = new JButton("주문관리");
		JButton menuOpenClose = new JButton("오픈마감");
		JButton menuExit = new JButton("닫기");
		
		menuExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(menuAll, LEFT_ALIGNMENT);
		add(menuBanner);
		add(menuOrder);
		add(menuOpenClose);
		add(menuExit);
		
	}

}

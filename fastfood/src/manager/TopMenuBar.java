package manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import manager.actionlistener.BarActionListener;
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
		BarMenuSubItem menuInsert = new BarMenuSubItem("상품등록");
		BarMenuSubItem menuSetList = new BarMenuSubItem("세트메뉴목록");
		BarMenuSubItem menuSetInsert = new BarMenuSubItem("세트메뉴등록");
		//menuItem = new JMenuItem(“메뉴항목1”, KeyEvent.VK_T); ->키보드 단축키 설정 가능
//		System.out.println(menuTitle.getMenuComponentCount());
//		System.out.println(menuTitle.getItem(1).getText());
		
		menuTitle.add(menuList);
		menuTitle.add(menuInsert);
		menuTitle.add(menuSetList);
		menuTitle.add(menuSetInsert);
		
		for(int i = 0; i < menuTitle.getMenuComponentCount(); i++) {
			menuTitle.getItem(i).addActionListener(barAction);
		}
		
		BarMenuSubTitle salesTitle = new BarMenuSubTitle("매출조회");
		BarMenuSubItem salesMonth = new BarMenuSubItem("월 매출조회");
		BarMenuSubItem salesYear = new BarMenuSubItem("년 매출조회");
		salesMonth.addActionListener(barAction);
		salesYear.addActionListener(barAction);
		salesTitle.add(salesMonth);
		salesTitle.add(salesYear);
		
		BarMenuSubItem calculateTitle = new BarMenuSubItem("정산");		
		BarMenuSubItem memberTitle = new BarMenuSubItem("매장관리");
		memberTitle.addActionListener(barAction);
		
		//openItem.addActionListener(new OpenActionListener());
		menuAll.add(menuTitle);
		menuAll.add(salesTitle);
		menuAll.add(calculateTitle);
		menuAll.add(memberTitle);
		
		add(menuAll, LEFT_ALIGNMENT);
		
		JPanel jpSpace = new JPanel();
		//jpSpace.setBorder(new LineBorder(Color.red));
		
		add(jpSpace);
		
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
		
		add(menuBanner);
		add(menuOrder);
		add(menuOpenClose);
		add(menuExit, RIGHT_ALIGNMENT);
		
	}

}

package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuBar;

import manager.actionlistener.BarActionListener;
import manager.component.bar.BarMenuSubItem;
import manager.component.bar.BarMenuSubTitle;
import manager.component.bar.BarMenuTitle;

public class TopMenuBar extends JMenuBar {
	
	ManagerMain main;
	
	public TopMenuBar(ManagerMain main) {
		
		this.main = main;
		
		BarActionListener barAction = new BarActionListener(main);		
		
		BarMenuTitle menuAll = new BarMenuTitle("�޴�");
		
		BarMenuSubTitle menuTitle = new BarMenuSubTitle("��ǰ����");		
		BarMenuSubItem menuList = new BarMenuSubItem("��ǰ���");		
		BarMenuSubItem menuInsert = new BarMenuSubItem("��ǰ���");
		BarMenuSubItem menuSetList = new BarMenuSubItem("��Ʈ�޴����");
		BarMenuSubItem menuSetInsert = new BarMenuSubItem("��Ʈ�޴����");
		//menuItem = new JMenuItem(���޴��׸�1��, KeyEvent.VK_T); ->Ű���� ����Ű ���� ����
//		System.out.println(menuTitle.getMenuComponentCount());
//		System.out.println(menuTitle.getItem(1).getText());
		
		menuTitle.add(menuList);
		menuTitle.add(menuInsert);
		menuTitle.add(menuSetList);
		menuTitle.add(menuSetInsert);
		
		for(int i = 0; i < menuTitle.getMenuComponentCount(); i++) {
			menuTitle.getItem(i).addActionListener(barAction);
		}
		
		BarMenuSubItem salesTitle = new BarMenuSubItem("������ȸ");
		BarMenuSubItem calculateTitle = new BarMenuSubItem("����");		
		BarMenuSubItem memberTitle = new BarMenuSubItem("�������");		
		
		//openItem.addActionListener(new OpenActionListener());
		menuAll.add(menuTitle);
		menuAll.add(salesTitle);
		menuAll.add(calculateTitle);
		menuAll.add(memberTitle);
		
		JButton menuBanner = new JButton("              �ΰ� �̹���");
		menuBanner.setEnabled(false);
		JButton menuOrder = new JButton("�ֹ�����");
		JButton menuOpenClose = new JButton("���¸���");
		JButton menuExit = new JButton("�ݱ�");
		
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

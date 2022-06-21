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
		
		BarMenuTitle menuAll = new BarMenuTitle("�޴�");
		
		BarMenuSubTitle menuTitle = new BarMenuSubTitle("��ǰ����");		
		BarMenuSubItem menuList = new BarMenuSubItem("��ǰ���");
		menuList.addActionListener(barAction);
		BarMenuSubItem menuInsert = new BarMenuSubItem("��ǰ���");
		menuInsert.addActionListener(barAction);
		//menuItem = new JMenuItem(���޴��׸�1��, KeyEvent.VK_T); ->Ű���� ����Ű ���� ����
		
		menuTitle.add(menuList);
		menuTitle.add(menuInsert);
		
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

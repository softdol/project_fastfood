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
		
		BarMenuSubTitle salesTitle = new BarMenuSubTitle("������ȸ");
		BarMenuSubItem salesMonth = new BarMenuSubItem("�� ������ȸ");
		BarMenuSubItem salesYear = new BarMenuSubItem("�� ������ȸ");
		salesMonth.addActionListener(barAction);
		salesYear.addActionListener(barAction);
		salesTitle.add(salesMonth);
		salesTitle.add(salesYear);
		
		BarMenuSubItem calculateTitle = new BarMenuSubItem("����");		
		BarMenuSubItem memberTitle = new BarMenuSubItem("�������");
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
		
		add(menuBanner);
		add(menuOrder);
		add(menuOpenClose);
		add(menuExit, RIGHT_ALIGNMENT);
		
	}

}

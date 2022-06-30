package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import kioske.YounukLee7.ArrayListTest;
import kioske.YounukLee7.Last_JFrame;
import kioske.YounukLee7.cartButton.CartButton;
import manager.component.ManagerCP;

public class Cart_mid extends JPanel{
	
	
//	public void remove(ArrayList arrayList, Last_JFrame screen) {
//		main.remove(arrayList);
//		screen.add(new Cart_mid(screen));
//	}
	
	public Cart_mid(Last_JFrame screen) {
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,500);
		setLayout(null);
//		// 이 패널의 layout이 null이기 때문에 아래 코드로 사이즈를 지정해주어야 한다
//		setPreferredSize(new Dimension(900, 2000));
		
		CartButton cartButton;
		int total = 0;
		JPanel pCenter = new JPanel();
		// 이 패널의 layout이 null이기 때문에 아래 코드로 사이즈를 지정해주어야 한다
		pCenter.setPreferredSize(new Dimension(900, 2000));
		pCenter.setBackground(new Color(0XFFE7DF));
		pCenter.setBounds(0,300,900,2000);
		pCenter.setLayout(null);
		
        // 매뉴 추가한 만큼
//		for (int i = 0; i < 3; i++) {
//			cartButton = new CartButton(main.get(i), pCenter, i);
////			total = total + cartButton.getSub_money();
//		}
		
		
		
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		jPanel.setBounds(0, 0, 900, 500);
		jPanel.setBackground(Color.black);
		add(jPanel);
		for(int i = 0; i < 3; i++) {
			JPanel jp1 = new JPanel();
			jp1.setLayout(null);
			jp1.setBackground(Color.WHITE);
			jp1.setBorder(new LineBorder(Color.BLACK));
			jp1.setBounds(0, 100 * i, 900, 100);
			jPanel.add(jp1);
			
			
		//jPanel.add(new CartButton(main.get(i), pCenter, i));
		}
		
		JScrollPane scrollPane = new JScrollPane(pCenter, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(150);
		scrollPane.setBounds(0, 0, 885, 500);
		
		//add(scrollPane);

	}
	

}

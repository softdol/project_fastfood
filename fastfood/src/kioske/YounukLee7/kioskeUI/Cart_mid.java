package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import kioske.YounukLee7.cartButton.CartButton;

public class Cart_mid extends JPanel{
	
	public Cart_mid() {
		
		setBackground(new Color(0XFFE7DF));
		setBounds(0,300,900,500);
		setLayout(null);
//		// �� �г��� layout�� null�̱� ������ �Ʒ� �ڵ�� ����� �������־�� �Ѵ�
//		setPreferredSize(new Dimension(900, 2000));
		
		CartButton cartButton;
		int total = 0;
		ArrayList<JPanel> arrpanel = new ArrayList<>();
		JPanel pCenter = new JPanel();
		// �� �г��� layout�� null�̱� ������ �Ʒ� �ڵ�� ����� �������־�� �Ѵ�
		pCenter.setPreferredSize(new Dimension(900, 2000));
		pCenter.setBackground(new Color(0XFFE7DF));
		pCenter.setBounds(0,300,900,2000);
		pCenter.setLayout(null);
        // �Ŵ� �߰��� ��ŭ
		for (int i = 0; i < 5; i++) {
			cartButton = new CartButton(arrpanel, pCenter, i);
			total = total + cartButton.getSub_money();
		}
		
		JScrollPane scrollPane = new JScrollPane(pCenter, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(150);
		scrollPane.setBounds(0, 0, 885, 500);
		
		add(scrollPane);

	}
	

}

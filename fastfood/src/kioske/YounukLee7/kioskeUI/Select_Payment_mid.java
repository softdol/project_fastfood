package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Payment_mid {
	
	public JPanel Select_Payment_mid() {
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(0XFFE7DF));
	    pCenter.setBounds(0,300,900,500);
	    pCenter.setLayout(null);
	    
		JLabel word1 = new JLabel("����������");
		word1.setFont(new Font("HY�߰��", Font.PLAIN, 40));
		word1.setOpaque(true);
		word1.setForeground(Color.red);
		word1.setBackground(new Color(0XFFE7DF));
		word1.setBounds(345, 50, 200, 40);
		
		JLabel word2 = new JLabel("�������ּ���");
		word2.setFont(new Font("HY�߰��", Font.PLAIN, 40));
		word2.setOpaque(true);
		word2.setForeground(Color.black);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(325, 130, 300, 40);
		
		JButton card = new JButton("ī��");
		card.setForeground(new Color(0xFFFFFF));
		card.setBackground(new Color(0XFFFFFF));
		card.setIcon(new ImageIcon("image/card.jpg"));
		card.setBounds(210, 240, 220, 220);
		
		JButton mobile = new JButton("�����");
		mobile.setForeground(new Color(0xFFFFFF));
		mobile.setBackground(new Color(0XFFFFFF));
		mobile.setIcon(new ImageIcon("image/mobile.jpg"));
		mobile.setBounds(455, 240, 220, 220);
	    
	    pCenter.add(word1);
		pCenter.add(word2);
		pCenter.add(card);
		pCenter.add(mobile);
		
		return pCenter;
	}

}

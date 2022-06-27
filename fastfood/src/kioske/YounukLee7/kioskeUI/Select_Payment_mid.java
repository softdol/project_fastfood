package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Card_Pay;

public class Select_Payment_mid extends JPanel{
	
	public Select_Payment_mid() {
		
		setBackground(new Color(0XFFE7DF));
	    setBounds(0,300,900,500);
	    setLayout(null);
	    
		JLabel word1 = new JLabel("결제수단을");
		word1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word1.setOpaque(true);
		word1.setForeground(Color.red);
		word1.setBackground(new Color(0XFFE7DF));
		word1.setBounds(345, 50, 200, 40);
		
		JLabel word2 = new JLabel("선택해주세요");
		word2.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word2.setOpaque(true);
		word2.setForeground(Color.black);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(325, 130, 300, 40);
		
		JButton card = new JButton("카드");
		card.setForeground(new Color(0xFFFFFF));
		card.setBackground(new Color(0XFFFFFF));
		card.setIcon(new ImageIcon("image/card.jpg"));
		card.setBounds(210, 240, 220, 220);
		
		card.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Card_Pay();
			}
		});
		
		JButton mobile = new JButton("모바일");
		mobile.setForeground(new Color(0xFFFFFF));
		mobile.setBackground(new Color(0XFFFFFF));
		mobile.setIcon(new ImageIcon("image/mobile.jpg"));
		mobile.setBounds(455, 240, 220, 220);
	    
	    add(word1);
		add(word2);
		add(card);
		add(mobile);
		
	}

}

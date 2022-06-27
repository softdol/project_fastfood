package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card_Pay_mid extends JPanel{
	
	public Card_Pay_mid() {
		
		setBackground(new Color(0XFFE7DF));
        setBounds(0,300,900,500);
        setLayout(null);
        
    	JLabel word1 = new JLabel("신용카드를");
    	word1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word1.setOpaque(true);
		word1.setForeground(Color.red);
		word1.setBackground(new Color(0XFFE7DF));
		word1.setBounds(345, 50, 200, 40);
		
		JLabel word2 = new JLabel("투입구에 넣어주세요");
		word2.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word2.setOpaque(true);
		word2.setForeground(Color.black);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(255, 130, 400, 40);
		
		JLabel label3 = new JLabel("카드 결제 이미지");
		label3.setBounds(240, 230, 400, 230);
		label3.setIcon(new ImageIcon("image/Card_pay.png"));
		
		add(word1);
		add(word2);
		add(label3);
		
	}

}

package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mobile_Pay_mid {
	
	public JPanel Mobile_Pay_mid() {
		
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(0XFFE7DF));
        pCenter.setBounds(0,300,900,500);
        pCenter.setLayout(null);
        
    	JLabel word1 = new JLabel("사용하실 쿠폰의 바코드를");
    	word1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word1.setOpaque(true);
		word1.setForeground(Color.red);
		word1.setBackground(new Color(0XFFE7DF));
		word1.setBounds(200, 50, 500, 40);
		
		JLabel word2 = new JLabel("아래 바코드 리더기에 스캔해주세요.");
		word2.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word2.setOpaque(true);
		word2.setForeground(Color.black);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(110, 130, 700, 40);
		
		JLabel label3 = new JLabel("카드 결제 이미지");
		label3.setBounds(240, 230, 400, 230);
		label3.setIcon(new ImageIcon("image/coupon_pay.png"));
		
		pCenter.add(word1);
		pCenter.add(word2);
		pCenter.add(label3);
		
		return pCenter;
	}

}

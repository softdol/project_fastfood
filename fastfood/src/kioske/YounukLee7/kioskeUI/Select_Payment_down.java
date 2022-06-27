package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Payment_down {
	
	public JPanel Select_Payment_down() {
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(0XFFF2DD));
		pSouth.setBounds(0,800,900,240);
		pSouth.setLayout(null);
		
		JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
		allpay.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		JLabel allmoney = new JLabel("17000¿ø");
		allmoney.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
		
		JButton payoff = new JButton("°áÁ¦ Ãë¼Ò");
		payoff.setForeground(new Color(0xFFFFFF));
		payoff.setBackground(new Color(0X000000));
		payoff.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		payoff.setBounds(40, 100, 800, 80);
		
		pSouth.add(allpay);
		pSouth.add(allmoney);
		pSouth.add(payoff);
		
		return pSouth;
	}

}

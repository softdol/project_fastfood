package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Down_yes_no_Button {
	
	public JPanel Down_yes_no_Button() {
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(0XFFF2DD));
		pSouth.setBounds(0,800,900,240);
		pSouth.setLayout(null);
		
		
		JLabel allpay = new JLabel("총 결제금액");
		allpay.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		JLabel allmoney = new JLabel("17000원");
		allmoney.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
	
		JButton pay_button = new JButton("결제 하기");
		pay_button.setForeground(new Color(0xFFFFFF));
		pay_button.setBackground(new Color(0XFF0000));
		pay_button.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		pay_button.setBounds(450, 100, 380, 80);
		
		JButton payoff_button = new JButton("결제 취소");
		payoff_button.setForeground(new Color(0xFFFFFF));
		payoff_button.setBackground(new Color(0X000000));
		payoff_button.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		payoff_button.setBounds(40, 100, 380, 80);
		
		pSouth.add(allpay);
		pSouth.add(allmoney);
		pSouth.add(pay_button);
		pSouth.add(payoff_button);
		
		return pSouth;
	}

}

package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Last_JFrame;

public class Down_yes_no_Button extends JPanel{
	
	public Down_yes_no_Button(Last_JFrame screen) {
		
		setBackground(new Color(0XFFF2DD));
		setBounds(0,800,900,240);
		setLayout(null);
		
		
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
		
		pay_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.veiw_Order_completed();
			}
		});
		
		JButton payoff_button = new JButton("결제 취소");
		payoff_button.setForeground(new Color(0xFFFFFF));
		payoff_button.setBackground(new Color(0X000000));
		payoff_button.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		payoff_button.setBounds(40, 100, 380, 80);
		
		payoff_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.veiw_Error();
			}
		});
		
		add(allpay);
		add(allmoney);
		add(pay_button);
		add(payoff_button);
		
	}

}

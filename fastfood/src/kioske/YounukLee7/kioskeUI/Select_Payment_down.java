package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Last_JFrame;

public class Select_Payment_down extends JPanel{
	
	public Select_Payment_down(Last_JFrame screen) {
		
		setBackground(new Color(0XFFF2DD));
		setBounds(0,800,900,240);
		setLayout(null);
		
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
		
		payoff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.veiw_Error();
			}
		});
		
		add(allpay);
		add(allmoney);
		add(payoff);
		
	}

}

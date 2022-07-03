package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Insert_List;
import kioske.YounukLee7.Last_JFrame;
import kioske.YounukLee7.Main_JFrame;

public class Down_yes_no_Button extends JPanel{
	
	Insert_List insert;
	Main_JFrame frame;
	
	public Down_yes_no_Button(Main_JFrame frame, String pay) {
		this.frame = frame;
		
		setBackground(new Color(0XFFF2DD));
		setBounds(0,800,900,240);
		setLayout(null);
		
		
		JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
		allpay.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		
		int sum = 0;
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		
		
		JLabel allmoney = new JLabel();
		allmoney.setText(String.valueOf(sum) + "¿ø");
		allmoney.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
	
		JButton pay_button = new JButton("°áÁ¦ ÇÏ±â");
		pay_button.setForeground(new Color(0xFFFFFF));
		pay_button.setBackground(new Color(0XFF0000));
		pay_button.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		pay_button.setBounds(450, 100, 380, 80);
		
		pay_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insert = new Insert_List(frame, pay);
				frame.veiw_Order_completed();
			}
		});
		
		JButton payoff_button = new JButton("°áÁ¦ Ãë¼Ò");
		payoff_button.setForeground(new Color(0xFFFFFF));
		payoff_button.setBackground(new Color(0X000000));
		payoff_button.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		payoff_button.setBounds(40, 100, 380, 80);
		
		payoff_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.veiw_Home();
			}
		});
		
		add(allpay);
		add(allmoney);
		add(pay_button);
		add(payoff_button);
		
	}

}

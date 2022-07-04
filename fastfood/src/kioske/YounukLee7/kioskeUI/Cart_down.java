package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Last_JFrame;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;

public class Cart_down extends JPanel{
	
	HomeMenuKiosk hMain;
	Main_JFrame frame;
	Last_JFrame screen;
	public JLabel allmoney;
	
	
	public Cart_down(Last_JFrame screen, Main_JFrame frame,  HomeMenuKiosk hMain) {
		this.screen = screen;
		this.frame = frame;
		this.hMain = hMain;
		int total = 0;
		
		setBackground(new Color(0Xdcdcdc));
		setBounds(0,800,900,240);
		setLayout(null);
		
		
		JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
		allpay.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0Xdcdcdc));
		allpay.setBounds(40, 30, 180, 30);
		
		
		int sum = 0;
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		allmoney = new JLabel();
		allmoney.setText(String.valueOf(sum) + "¿ø");
		allmoney.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0Xdcdcdc));
		allmoney.setBounds(720, 30, 300, 30);
	
		JButton order_completed_button = new JButton("ÁÖ¹® ¿Ï·á");
		order_completed_button.setForeground(new Color(0xFFFFFF));
		order_completed_button.setBackground(new Color(0XFF0000));
		order_completed_button.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		order_completed_button.setBounds(450, 100, 380, 80);
		
		order_completed_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.veiw_Select_Payment();
				//screen.veiw_Select_Payment(frame);
			}
		});
		
		JButton more_order_button = new JButton("Ãß°¡ ÁÖ¹®");
		more_order_button.setForeground(new Color(0xFFFFFF));
		more_order_button.setBackground(new Color(0X000000));
		more_order_button.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 40));
		more_order_button.setBounds(40, 100, 380, 80);
		more_order_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.veiw_Home();
				//screen.dispose();
				//hMain.setPrice();
			}
		});
		
		add(allpay);
		add(allmoney);
		add(order_completed_button);
		add(more_order_button);
	}

	
}

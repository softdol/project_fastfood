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

public class Select_Payment_down extends JPanel{
	
	public Select_Payment_down(Main_JFrame screen) {
		
		setBackground(new Color(0XFFF2DD));
		setBounds(0,800,900,240);
		setLayout(null);
		
		JLabel allpay = new JLabel("�� �����ݾ�");
		allpay.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		
		int sum = 0;
		for(int i = 0; i < screen.orderList.size(); i ++) {
			
			if(screen.orderList.get(i).getSET_IDX()!= 0) {
				sum += (screen.orderList.get(i).getORDER_PRICE_TOTAL() * (100- screen.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += screen.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		
		
		JLabel allmoney = new JLabel();
		allmoney.setText(String.valueOf(sum) + "��");
		allmoney.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
		
		JButton payoff = new JButton("���� ���");
		payoff.setForeground(new Color(0xFFFFFF));
		payoff.setBackground(new Color(0X000000));
		payoff.setFont(new Font("HY�߰��", Font.PLAIN, 40));
		payoff.setBounds(40, 100, 800, 80);
		
		payoff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.veiw_Final_payment();
			}
		});
		
		add(allpay);
		add(allmoney);
		add(payoff);
		
	}

}

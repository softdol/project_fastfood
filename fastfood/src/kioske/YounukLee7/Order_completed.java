package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Order_completed extends JFrame{
	
	int order_num = 1;
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel word1 = new JLabel("주문이 완료되었습니다!");
	JLabel word2 = new JLabel("주문번호");
	JLabel order_number = new JLabel("1");
	JLabel payImage = new JLabel("결제 완료 이미지");
	JLabel logo = new JLabel("로고");
	JLabel menuName = new JLabel("매뉴 이름");
	
	public Order_completed() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		word1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word1.setBounds(225, 0, 600,200);
		
		word2.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		word2.setOpaque(true);
		word2.setForeground(Color.red);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(380, 150, 300, 30);
		
		order_number.setText(String.valueOf(order_num));
		order_number.setFont(new Font("HY견고딕", Font.PLAIN, 150));
		order_number.setOpaque(true);
		order_number.setForeground(Color.red);
		order_number.setBackground(new Color(0XFFE7DF));
		order_number.setHorizontalAlignment(JLabel.CENTER);
		order_number.setBounds(130, 200, 600, 150);
		
		payImage.setBounds(240, 350,400,230);
		payImage.setIcon(new ImageIcon("image/pay_exit.png"));
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menuName.setBounds(280, 50, 500, 200);
		menuName.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		
		Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Start_Screen();
				setVisible(false);
			}
		});
		
		time.start();
		
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pSouth.add(word1);
		pSouth.add(word2);
		pSouth.add(order_number);
		pSouth.add(payImage);
		
		setLayout(null);
		setTitle("주문 완료");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Order_completed();
	}
}

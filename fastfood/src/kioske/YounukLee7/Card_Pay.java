package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card_Pay extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel logo = new JLabel("로고");
	JLabel menuName = new JLabel("매뉴 이름");
	JLabel word1 = new JLabel("신용카드를");
	JLabel word2 = new JLabel("투입구에 넣어주세요");
	JLabel label3 = new JLabel("카드 결제 이미지");
	JLabel allpay = new JLabel("총 결제금액");
	JLabel money = new JLabel("17000원");
	JButton pay_button = new JButton("결제 하기");
	JButton payoff_button = new JButton("결제 취소");
	
	public Card_Pay() {
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
        pCenter.setBackground(new Color(0XFFE7DF));
        pCenter.setBounds(0,300,900,500);
        pCenter.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFF2DD));
		pSouth.setBounds(0,800,900,240);
		pSouth.setLayout(null);
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menuName.setBounds(280, 50, 500, 200);
		menuName.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		
		word1.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word1.setOpaque(true);
		word1.setForeground(Color.red);
		word1.setBackground(new Color(0XFFE7DF));
		word1.setBounds(345, 50, 200, 40);
		
		word2.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		word2.setOpaque(true);
		word2.setForeground(Color.black);
		word2.setBackground(new Color(0XFFE7DF));
		word2.setBounds(255, 130, 400, 40);
		
		label3.setBounds(240, 230, 400, 230);
		label3.setIcon(new ImageIcon("image/Card_pay.png"));
		
		allpay.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		money.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		money.setOpaque(true);
		money.setForeground(Color.RED);
		money.setBackground(new Color(0XFFF2DD));
		money.setBounds(720, 30, 300, 30);
	
		pay_button.setForeground(new Color(0xFFFFFF));
		pay_button.setBackground(new Color(0XFF0000));
		pay_button.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		pay_button.setBounds(450, 100, 380, 80);
		
		pay_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Order_completed();
				setVisible(false); 
			}  
		});
		
		payoff_button.setForeground(new Color(0xFFFFFF));
		payoff_button.setBackground(new Color(0X000000));
		payoff_button.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		payoff_button.setBounds(40, 100, 380, 80);
		
		payoff_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Error_Image();
				setVisible(false); 
			}  
		});
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pCenter.add(word1);
		pCenter.add(word2);
		pCenter.add(label3);
		
		pSouth.add(allpay);
		pSouth.add(money);
		pSouth.add(pay_button);
		pSouth.add(payoff_button);
		
		add(pNorth);
		add(pCenter);
		add(pSouth);
		
		setLayout(null);
		setTitle("카드 결체");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Card_Pay();
	}
}

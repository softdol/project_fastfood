package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import oracle.net.aso.f;

public class Select_Payment extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel logo = new JLabel("로고");
	JLabel menuName = new JLabel("매뉴 이름");
	JLabel word1 = new JLabel("결제수단을");
	JLabel word2 = new JLabel("선택해주세요");
	JButton card = new JButton("카드");
	JButton mobile = new JButton("모바일");
	JLabel allpay = new JLabel("총 결제금액");
	JLabel allmoney = new JLabel("17000원");
	JButton payoff = new JButton("결제 취소");
	
	public Select_Payment() {
		
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
		word2.setBounds(325, 130, 300, 40);
		
		card.setForeground(new Color(0xFFFFFF));
		card.setBackground(new Color(0XFFFFFF));
		card.setIcon(new ImageIcon("image/card.jpg"));
		card.setBounds(210, 240, 220, 220);
		
		card.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Card_Pay();
				setVisible(false);
			}  
		});
		
		mobile.setForeground(new Color(0xFFFFFF));
		mobile.setBackground(new Color(0XFFFFFF));
		mobile.setIcon(new ImageIcon("image/mobile.jpg"));
		mobile.setBounds(455, 240, 220, 220);
		
		mobile.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Mobile_Pay();
				setVisible(false);
			}  
		});
		
		allpay.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		allmoney.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
		
		payoff.setForeground(new Color(0xFFFFFF));
		payoff.setBackground(new Color(0X000000));
		payoff.setFont(new Font("HY견고딕", Font.PLAIN, 40));
		payoff.setBounds(40, 100, 800, 80);
		
		payoff.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Error_Image();
				setVisible(false);
				
			}  
		});
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pCenter.add(word1);
		pCenter.add(word2);
		pCenter.add(card);
		pCenter.add(mobile);
		
		pSouth.add(allpay);
		pSouth.add(allmoney);
		pSouth.add(payoff);
		
		add(pNorth);
		add(pCenter);
		add(pSouth);
		
		setLayout(null);
		setTitle("결제 선택창");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Select_Payment();
	}
}

package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cart extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();

	//JPanel[] panel = new JPanel[100];
	ArrayList<JPanel> panel = new ArrayList<>();
	JPanel panel2 = new JPanel();
	
	JPanel scrollJPanel = new JPanel();
	
	JLabel logo = new JLabel("·Î°í");
	JLabel order = new JLabel("ÁÖ¹® ³»¿ª");
	JLabel menuImg = new JLabel("¸Å´º ÀÌ¹ÌÁö");
	JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å ¼¼Æ® »çÀÌ´Ù °¨ÀÚÆ¢±è");
	JLabel cnt = new JLabel("1");
	JLabel menuMoney = new JLabel("5500¿ø");
	JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
	JLabel money = new JLabel("17000¿ø");
	//JButton cancel = new JButton("Ãë¼Ò");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton button1 = new JButton("ÁÖ¹® ¿Ï·á");
	JButton button2 = new JButton("Ãß°¡ ÁÖ¹®");
	
	public Cart() {
		
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
		
		order.setBounds(280, 50, 500, 200);
		order.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		
		
		for (int i = 0; i < 2; i++) {
			JPanel p = new JPanel(); 
			
			p.setBounds(50, 150 * i, 900, 150);
			//p.setBackground(new Color(0XFFFFEE));
			p.setBorder(new LineBorder(Color.red, i + 2));
			//p.setLayout(null);
			
			JButton cancel = new JButton("Ãë¼Ò");
			
			cancel.setBounds(10, 50, 100, 50);
			cancel.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 20));
			cancel.setBackground(Color.black);
			cancel.setForeground(Color.white);
			/*
			menuImg.setBounds(120, 0, 150, 150);
			menuImg.setIcon(new ImageIcon("image/set2.jpg"));
			menuImg.setText("");
			
			menuName.setBounds(280, 0, 500, 60);
			menuName.setOpaque(true);
			menuName.setHorizontalAlignment(JLabel.CENTER);
			menuName.setForeground(Color.black);
			menuName.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
			menuName.setBackground(new Color(0XFFFF00));
			
			minus.setBounds(280, 80, 100, 50);
			minus.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 20));
			minus.setBackground(Color.black);
			minus.setForeground(Color.white);
			
			cnt.setBounds(380, 80, 100, 50);
			cnt.setOpaque(true);
			cnt.setHorizontalAlignment(JLabel.CENTER);
			cnt.setForeground(Color.black);
			cnt.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
			cnt.setBackground(new Color(0XFFFFFF));
			
			plus.setBounds(480, 80, 100, 50);
			plus.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 20));
			plus.setBackground(Color.black);
			plus.setForeground(Color.white);
			
			menuMoney.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
			menuMoney.setOpaque(true);
			menuMoney.setForeground(Color.RED);
			menuMoney.setBackground(new Color(0XFFE7DF));
			menuMoney.setBounds(600, 90, 200, 30);
			*/
			p.add(cancel);
//			p.add(menuImg);
//			p.add(menuName);
//			p.add(minus);
//			p.add(plus);
//			p.add(cnt);
//			p.add(menuMoney);
			
			pCenter.add(p);
			panel.add(p);
		}
		//panel.size();
		for(JPanel p : panel) {
			System.out.println("1");
		}
		
		allpay.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		money.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		money.setOpaque(true);
		money.setForeground(Color.RED);
		money.setBackground(new Color(0XFFF2DD));
		money.setBounds(720, 30, 300, 30);
	
		button1.setForeground(new Color(0xFFFFFF));
		button1.setBackground(new Color(0XFF0000));
		button1.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 40));
		button1.setBounds(450, 100, 380, 80);
		
		button2.setForeground(new Color(0xFFFFFF));
		button2.setBackground(new Color(0X000000));
		button2.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 40));
		button2.setBounds(40, 100, 380, 80);
		
		pNorth.add(logo);
		pNorth.add(order);
		
		pSouth.add(allpay);
		pSouth.add(money);
		pSouth.add(button1);
		pSouth.add(button2);
		
		add(pNorth);
		add(pCenter);
		add(pSouth);
		
		setLayout(null);
		setTitle("Cart");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Cart();
	}
}

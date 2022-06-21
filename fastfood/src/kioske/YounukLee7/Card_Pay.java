package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card_Pay extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel logo = new JLabel("·Î°í");
	JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å");
	JLabel label1 = new JLabel("½Å¿ëÄ«µå¸¦");
	JLabel label2 = new JLabel("ÅõÀÔ±¸¿¡ ³Ö¾îÁÖ¼¼¿ä");
	JLabel label3 = new JLabel("Ä«µå °áÁ¦ ÀÌ¹ÌÁö");
	JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
	JLabel money = new JLabel("17000¿ø");
	JButton button1 = new JButton("°áÁ¦ ÇÏ±â");
	JButton button2 = new JButton("°áÁ¦ Ãë¼Ò");
	
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
		menuName.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		
		label1.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 40));
		label1.setOpaque(true);
		label1.setForeground(Color.red);
		label1.setBackground(new Color(0XFFE7DF));
		label1.setBounds(345, 50, 200, 40);
		
		label2.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 40));
		label2.setOpaque(true);
		label2.setForeground(Color.black);
		label2.setBackground(new Color(0XFFE7DF));
		label2.setBounds(255, 130, 400, 40);
		
		label3.setBounds(240, 230, 400, 230);
		label3.setIcon(new ImageIcon("image/Card_pay.png"));
		
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
		pNorth.add(menuName);
		
		pCenter.add(label1);
		pCenter.add(label2);
		pCenter.add(label3);
		
		pSouth.add(allpay);
		pSouth.add(money);
		pSouth.add(button1);
		pSouth.add(button2);
		
		add(pNorth);
		add(pCenter);
		add(pSouth);
		
		setLayout(null);
		setTitle("Card_Pay");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Card_Pay();
	}
}

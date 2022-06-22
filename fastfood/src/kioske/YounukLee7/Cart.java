package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import kioske.YounukLee7.cartButton.CartButton;

public class Cart extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();

	ArrayList<JPanel> panel = new ArrayList<>();
	JPanel panel2 = new JPanel();
	
	JPanel scrollJPanel = new JPanel();
	
	JLabel logo = new JLabel("·Î°í");
	JLabel order = new JLabel("ÁÖ¹® ³»¿ª");
	JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
	JLabel money = new JLabel("17000¿ø");
	JButton button1 = new JButton("ÁÖ¹® ¿Ï·á");
	JButton button2 = new JButton("Ãß°¡ ÁÖ¹®");
//	JLabel menuImg = new JLabel("¸Å´º ÀÌ¹ÌÁö");
//  JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å ¼¼Æ® »çÀÌ´Ù °¨ÀÚÆ¢±è");
//	JLabel cnt = new JLabel("1");
//	JLabel menuMoney = new JLabel("5500¿ø");
//  JButton cancel = new JButton("Ãë¼Ò");
//	JButton plus = new JButton("+");
//	JButton minus = new JButton("-");
	
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
		
		JScrollPane scrollPane = new JScrollPane(pCenter, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(0, 300, 900, 500);
		add(pCenter);
		
		
		CartButton button = new CartButton(pCenter, 4);
			
		// panel.add(p);
		
		// panel.size();
		
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

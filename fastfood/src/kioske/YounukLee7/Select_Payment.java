package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Payment extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel logo = new JLabel("·Î°í");
	JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å");
	JLabel label1 = new JLabel("°áÁ¦¼ö´ÜÀ»");
	JLabel label2 = new JLabel("¼±ÅÃÇØÁÖ¼¼¿ä");
	JButton button1 = new JButton("Ä«µå");
	JButton button2 = new JButton("¸ð¹ÙÀÏ");
	JLabel allpay = new JLabel("ÃÑ °áÁ¦±Ý¾×");
	JLabel money = new JLabel("17000¿ø");
	JButton button3 = new JButton("°áÁ¦ Ãë¼Ò");
	
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
		label2.setBounds(325, 130, 300, 40);
		
		button1.setForeground(new Color(0xFFFFFF));
		button1.setBackground(new Color(0XFFF2EE));
		button1.setIcon(new ImageIcon("image/card.jpg"));
		button1.setBounds(206, 250, 188, 200);
		
		button2.setForeground(new Color(0xFFFFF));
		button2.setBackground(new Color(0XFFF2EE));
		button2.setIcon(new ImageIcon("image/mobile.jpg"));
		button2.setBounds(496, 250, 188, 200);
		
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
		
		button3.setForeground(new Color(0xFFFFFF));
		button3.setBackground(new Color(0X000000));
		button3.setFont(new Font("¸¼Àº°íµñ±½°Ô", Font.PLAIN, 40));
		button3.setBounds(40, 100, 800, 80);
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pCenter.add(label1);
		pCenter.add(label2);
		pCenter.add(button1);
		pCenter.add(button2);
		
		pSouth.add(allpay);
		pSouth.add(money);
		pSouth.add(button3);
		
		add(pNorth);
		add(pCenter);
		add(pSouth);
		
		setLayout(null);
		setTitle("Select_Payment");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Select_Payment();
	}
}

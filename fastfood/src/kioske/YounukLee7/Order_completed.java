package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Order_completed extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel label1 = new JLabel("ÁÖ¹®ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù!");
	JLabel label2 = new JLabel("ÁÖ¹®¹øÈ£");
	JLabel label3 = new JLabel("1");
	JLabel payImage = new JLabel("°áÁ¦ ¿Ï·á ÀÌ¹ÌÁö");
	JLabel logo = new JLabel("·Î°í");
	JLabel menuName = new JLabel("Å©¸®½ºÇÇ ¹ö°Å");
	
	public Order_completed() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		label1.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 40));
		label1.setBounds(225, 0, 600,200);
		
		label2.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		label2.setOpaque(true);
		label2.setForeground(Color.red);
		label2.setBackground(new Color(0XFFE7DF));
		label2.setBounds(380, 150, 300, 30);
		
		label3.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 150));
		label3.setOpaque(true);
		label3.setForeground(Color.red);
		label3.setBackground(new Color(0XFFE7DF));
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setBounds(130, 200, 600, 150);
		
		payImage.setBounds(240, 350,400,230);
		payImage.setIcon(new ImageIcon("image/pay_exit.png"));
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menuName.setBounds(280, 50, 500, 200);
		menuName.setFont(new Font("¸¼Àº °íµñ ±½°Ô", Font.PLAIN, 30));
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pSouth.add(label1);
		pSouth.add(label2);
		pSouth.add(label3);
		pSouth.add(payImage);
		
		setLayout(null);
		setTitle("Order_completed");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Order_completed();
	}
}

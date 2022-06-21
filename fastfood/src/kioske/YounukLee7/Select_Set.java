package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
	
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Set extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton button1 = new JButton("¥‹«∞");
	JButton button2 = new JButton("ºº∆Æ");
	JLabel label = new JLabel("º±≈√«ÿ¡÷ººø‰");
	JLabel label2 = new JLabel("∑Œ∞Ì");
	JLabel label3= new JLabel("≈©∏ÆΩ∫«« πˆ∞≈");
	
	public Select_Set() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ ±Ω∞‘", Font.PLAIN, 50));
		label.setBounds(280, 50, 300,200);
		
		label2.setBounds(50, 50, 200, 200);
		label2.setIcon(new ImageIcon("image/logo.png"));
		
		label3.setBounds(280, 50, 500, 200);
		label3.setFont(new Font("∏º¿∫ ∞ÌµÒ ±Ω∞‘", Font.PLAIN, 30));
		
		
		button1.setForeground(new Color(0x000000));
		button1.setBackground(new Color(0xFFFFFF));
		button1.setBounds(173, 200, 250, 350);
		
		button2.setForeground(new Color(0x000000));
		button2.setBackground(new Color(0xFFFFFF));
		button2.setBounds(463, 200, 250, 350);
		
		button1.setIcon(new ImageIcon("image/solo.png"));
		button2.setIcon(new ImageIcon("image/set.jpg"));
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(label2);
		pNorth.add(label3);
		
		pSouth.add(button1);
		pSouth.add(button2);
		pSouth.add(label);
		
		setLayout(null);
		setTitle("Select_Set");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Select_Set();
	}
}

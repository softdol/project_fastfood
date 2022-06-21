package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Select_Takeout extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton button1 = new JButton("매장 식사");
	JButton button2 = new JButton("포장 주문");
	JLabel label = new JLabel("선택해주세요");
	CardLayout cardLayout = new CardLayout();
	
	public Select_Takeout() {
		
		pNorth.setBackground(new Color(0XFFFFFF));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(cardLayout);
        
        Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(pNorth);
			}
		});
        
        time.start();
		
        pNorth.add(new ImageLabel("image/5.jpg"));
        pNorth.add(new ImageLabel("image/6.jpg"));
        pNorth.add(new ImageLabel("image/7.jpg"));
		
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		label.setFont(new Font("맑은 고딕 굵게", Font.PLAIN, 50));
		label.setBounds(280, 50, 300,200);
		
		button1.setForeground(new Color(0x000000));
		button1.setBackground(new Color(0xFFFFFF));
		button1.setBounds(173, 200, 250, 350);
		
		button2.setForeground(new Color(0x000000));
		button2.setBackground(new Color(0xFFFFFF));
		button2.setBounds(463, 200, 250, 350);
		
		button1.setIcon(new ImageIcon("image/8.first.jpg"));
		button2.setIcon(new ImageIcon("image/8.second.jpg"));
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		pSouth.add(button1);
		pSouth.add(button2);
		pSouth.add(label);
		
		setLayout(null);
		setTitle("Select_Takeout");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Takeout();
	}
}

package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error_Image extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JLabel payImage = new JLabel("결제 완료 이미지");
	JLabel logo = new JLabel("로고");
	JLabel menuName = new JLabel("크리스피 버거");
	
	public Error_Image() {
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFFFFF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		payImage.setBounds(222, 100, 500, 500);
		payImage.setIcon(new ImageIcon("image/error.png"));
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menuName.setBounds(280, 50, 500, 200);
		menuName.setFont(new Font("맑은 고딕 굵게", Font.PLAIN, 30));
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pSouth.add(payImage);
		
		setLayout(null);
		setTitle("Error_Image");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Error_Image();
	}
}

package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_LargeSet extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton button1 = new JButton("아니오");
	JButton button2 = new JButton("예");
	JLabel label = new JLabel("<html><body style='text-align:center;'>700원 추가하시면 사이드와 음료가"
							+ "<br />라지사이즈로 변경됩니다."
							+ "<p>업그레이드 하시겠습니까?</body></html>");
	JLabel label2 = new JLabel("로고");
	JLabel label3= new JLabel("크리스피 버거");
	// 제품 사진
	JLabel label4= new JLabel();
	
	public Select_LargeSet() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		label.setFont(new Font("맑은 고딕 굵게", Font.PLAIN, 30));
		label.setBounds(210, 0, 500,200);
		
		label2.setBounds(50, 50, 200, 200);
		label2.setIcon(new ImageIcon("image/logo.png"));
		
		label3.setBounds(280, 50, 500, 200);
		label3.setFont(new Font("맑은 고딕 굵게", Font.PLAIN, 30));
		
		label4.setBounds(260, 170, 360, 260);
		label4.setIcon(new ImageIcon("image/set1.jpg"));
		
		button1.setForeground(new Color(0xFFFFFF));
		button1.setBackground(new Color(0x000000));
		button1.setFont(new Font("맑은 고딕 굵게", Font.PLAIN, 30));
		button1.setBounds(173, 450, 250, 60);
		
		button2.setForeground(new Color(0xFFFFF));
		button2.setBackground(new Color(0xFF0000));
		button2.setFont(new Font("맑은 고딕 굵게", Font.PLAIN, 30));
		button2.setBounds(463, 450, 250, 60);
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(label2);
		pNorth.add(label3);
		
		pSouth.add(button1);
		pSouth.add(button2);
		pSouth.add(label);
		pSouth.add(label4);
		
		setLayout(null);
		setTitle("Select_LargeSet");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_LargeSet();
	}
}

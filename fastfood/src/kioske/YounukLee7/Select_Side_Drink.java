package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Select_Side_Drink extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton side_button = new JButton("사이드변경");
	JButton drink_button = new JButton("음료변경");
	JButton cart_button = new JButton("카트 담기");
	JLabel logo = new JLabel("로고");
	JLabel menuName = new JLabel("세트 매뉴 이름");
	JLabel burgerlabel = new JLabel("햄버거 사진");
	JLabel side_label = new JLabel("사이드 사진");
	JLabel drink_label = new JLabel("음료 사진");
	String check;
	
	public Select_Side_Drink() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,740);
		pSouth.setLayout(null);
		
		burgerlabel.setIcon(new ImageIcon("image/solo1.png"));
		burgerlabel.setBounds(100, 150, 200, 170);
		
		side_label.setIcon(new ImageIcon("image/side.png"));
		side_label.setBounds(350, 150, 200, 170);
		
		drink_label.setIcon(new ImageIcon("image/coke.jpg"));
		drink_label.setBounds(600, 150, 200, 170);
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menuName.setBounds(280, 50, 500, 200);
		menuName.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		
		side_button.setForeground(new Color(0x000000));
		side_button.setBackground(new Color(0xCCCCCC));
		side_button.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		side_button.setBounds(375, 330, 150, 50);
		
		side_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
				setVisible(false); // 다음화면으로 넘어가면 이전화면 안보이게 하기
			}  
		});
		
		drink_button.setForeground(new Color(0x000000));
		drink_button.setBackground(new Color(0xCCCCCC));
		drink_button.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		drink_button.setBounds(625, 330, 150, 50);
		
		drink_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
				setVisible(false); // 다음화면으로 넘어가면 이전화면 안보이게 하기
			}  
		});
		
		cart_button.setForeground(new Color(0xFFFFFF));
		cart_button.setBackground(new Color(0x000000));
		cart_button.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		cart_button.setBounds(150, 400, 590, 70);
		
		cart_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
				setVisible(false); // 다음화면으로 넘어가면 이전화면 안보이게 하기
			}  
		});
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo);
		pNorth.add(menuName);
		
		pSouth.add(side_button);
		pSouth.add(drink_button);
		pSouth.add(cart_button);
		pSouth.add(burgerlabel);
		pSouth.add(side_label);
		pSouth.add(drink_label);
		
		setLayout(null);
		setTitle("사이드 또는 음료 변경 후 담기");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Side_Drink();
	}
}

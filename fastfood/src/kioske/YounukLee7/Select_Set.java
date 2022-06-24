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


public class Select_Set extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton single_button = new JButton("단품");
	JButton set_button = new JButton("세트");
	JLabel select_label = new JLabel("선택해주세요");
	JLabel logo = new JLabel("로고");
	JLabel menu_name = new JLabel("매뉴 이름");
	String check;
	
	public Select_Set() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		select_label.setFont(new Font("HY견고딕", Font.PLAIN, 50));
		select_label.setBounds(280, 50, 300,200);
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menu_name.setBounds(280, 50, 500, 200);
		menu_name.setFont(new Font("HY견고딕", Font.PLAIN, 30));
		
		single_button.setBounds(173, 200, 250, 350);
		
		set_button.setBounds(463, 200, 250, 350);
		
		single_button.setIcon(new ImageIcon("image/solo.png"));
		set_button.setIcon(new ImageIcon("image/set.jpg"));
		
		single_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				check = "N"; // String 단품
				
				setVisible(false); // 다음화면으로 넘어가면 이전화면 안보이게 하기
			}  
		});
		
		set_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				check = "S"; // String 세트
				
				new Select_Set_Size();
				setVisible(false); // 다음화면으로 넘어가면 이전화면 안보이게 하기
			}  
		});
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo);
		pNorth.add(menu_name);
		
		pSouth.add(single_button);
		pSouth.add(set_button);
		pSouth.add(select_label);
		
		setLayout(null);
		setTitle("단품 또는 세트");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new Select_Set();
	}
}

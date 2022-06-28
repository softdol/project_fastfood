package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.action.CategoryAction;

public class Category extends JPanel{
	HomeMenuKiosk hMain;
	
	public Category(HomeMenuKiosk hMain) {
		this.hMain = hMain;
		
		EmptyBorder border = new EmptyBorder(getInsets());

		//JPanel catePanel = new JPanel();
				
		setBounds(0, 0, 200, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
		String[] cate = {"홈", "햄버거", "사이드", "음료", "디저트"};// 카테고리 추가하려면 여기에 추가
		
		// 클래스화 카테고리
		
			
		ImageIcon icon = new ImageIcon("pos_image/logo_title.png");		
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel logo = new JLabel(changeIcon);

		logo.setBounds(0,0,200,100);
		add(logo);
		
		 
		//CategoryAction listener = new CategoryAction(new MainPanel(), MainPanel.mainPanel );
		
		
		for(int i = 0; i <cate.length; ++i) {
			JButton btn1 = new JButton(cate[i]);
			btn1.setFont(new Font("궁서체", Font.PLAIN,40));
			btn1.setBackground(new Color(0xFFFFFF));
			btn1.setBounds(0,100*(i+1),200,100);
			btn1.setBorder(border);
			btn1.addActionListener(new CategoryAction(hMain, i));
			add(btn1);
		}
		
	}

	
	
}

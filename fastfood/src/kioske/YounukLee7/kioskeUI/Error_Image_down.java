package kioske.YounukLee7.kioskeUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Error_Image_down extends JPanel{
	
	public Error_Image_down() {
		
		setBackground(new Color(0XFFFFFF));
		setBounds(0,300,900,770);
		setLayout(null);
		
		JLabel payImage = new JLabel("결제 완료 이미지");
		payImage.setBounds(222, 100, 500, 500);
		payImage.setIcon(new ImageIcon("image/error.png"));
		
		add(payImage);
	}

}

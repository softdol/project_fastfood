package kioske.YounukLee7;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Start_Screen extends JFrame{

	JPanel panel = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	public Start_Screen() {
		
		panel.setBounds(0,0,900,1040);
		panel.setLayout(cardLayout);
		
		// 화면 약 3초마다 넘기기
		Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(panel);
			}
		});
		
		// 화면 시작 지점
		time.start();
		
		// 화면들
		panel.add(new ImageLabel("image/1.jpg"));
		panel.add(new ImageLabel("image/2.jpg"));
		panel.add(new ImageLabel("image/3.jpg"));
		panel.add(new ImageLabel("image/4.jpg"));
		
		// 화면 아무곳이나 클릭시 다음 화면으로 넘어감
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Select_Takeout();
				setVisible(false); // 다음화면으로 넘어가면 이전화면 안보이게 하기
			}  
		});
		
		add(panel);
		
		setLayout(null);
		setTitle("첫 화면");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Start_Screen();
	}
}

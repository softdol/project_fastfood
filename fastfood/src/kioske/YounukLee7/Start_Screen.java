package kioske.YounukLee7;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Start_Screen extends JFrame{

	JPanel panel = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	public Start_Screen() {
		
		panel.setBounds(0,0,900,1040);
		panel.setLayout(cardLayout);
		
		Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(panel);
			}
		});
		
		time.start();
		
		panel.add(new ImageLabel("image/1.jpg"));
		panel.add(new ImageLabel("image/2.jpg"));
		panel.add(new ImageLabel("image/3.jpg"));
		panel.add(new ImageLabel("image/4.jpg"));
		add(panel);
		
		setLayout(null);
		setTitle("Strat Screen");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Start_Screen();
	}
}

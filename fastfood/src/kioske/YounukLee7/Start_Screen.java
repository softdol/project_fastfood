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
		
		// ȭ�� �� 3�ʸ��� �ѱ��
		Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(panel);
			}
		});
		
		// ȭ�� ���� ����
		time.start();
		
		// ȭ���
		panel.add(new ImageLabel("image/1.jpg"));
		panel.add(new ImageLabel("image/2.jpg"));
		panel.add(new ImageLabel("image/3.jpg"));
		panel.add(new ImageLabel("image/4.jpg"));
		
		// ȭ�� �ƹ����̳� Ŭ���� ���� ȭ������ �Ѿ
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new Select_Takeout();
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		add(panel);
		
		setLayout(null);
		setTitle("ù ȭ��");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Start_Screen();
	}
}

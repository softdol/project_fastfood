package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Completed_up extends JPanel{

	public Completed_up() {
		setBackground(new Color(0XFFF2DD));
		setBounds(0, 0, 900, 300);
		setLayout(null);

		JLabel logo = new JLabel("�ΰ�");
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));

		JLabel payment = new JLabel("���� �Ϸ�");
		payment.setBounds(280, 50, 500, 200);
		payment.setFont(new Font("HY�߰��", Font.PLAIN, 30));

		add(logo);
		add(payment);
	}
	
}

package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cart_up extends JPanel {

	public Cart_up() {

		setBackground(new Color(0XFFF2DD));
		setBounds(0, 0, 900, 300);
		setLayout(null);

		JLabel logo = new JLabel("�ΰ�");
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));

		JLabel order = new JLabel("�ֹ� ����");
		order.setBounds(280, 50, 500, 200);
		order.setFont(new Font("HY�߰��", Font.PLAIN, 30));

		add(logo);
		add(order);
	}

}

package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Select_Set_Size_down {
	
	public JPanel Select_Set_Size_down() {
		
		JPanel pSouth = new JPanel();
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,740);
		pSouth.setLayout(null);
		
		JLabel label = new JLabel("<html><body style='text-align:center;'>700�� �߰��Ͻø� ���̵�� ���ᰡ"
				+ "<br />����������� ����˴ϴ�."
				+ "<p>���׷��̵� �Ͻðڽ��ϱ�?</body></html>");
		label.setFont(new Font("HY�߰���", Font.PLAIN, 30));
		label.setBounds(210, 0, 500,200);
		
		JLabel image_label = new JLabel();
		image_label.setBounds(260, 170, 360, 260);
		image_label.setIcon(new ImageIcon("image/set1.jpg"));
		
		JButton no_button = new JButton("�ƴϿ�");
		no_button.setForeground(new Color(0xFFFFFF));
		no_button.setBackground(new Color(0x000000));
		no_button.setFont(new Font("HY�߰���", Font.PLAIN, 30));
		no_button.setBounds(173, 450, 250, 60);
		
		JButton yes_button = new JButton("��");
		yes_button.setForeground(new Color(0xFFFFFF));
		yes_button.setBackground(new Color(0xFF0000));
		yes_button.setFont(new Font("HY�߰���", Font.PLAIN, 30));
		yes_button.setBounds(463, 450, 250, 60);
		
		pSouth.add(no_button);
		pSouth.add(yes_button);
		pSouth.add(label);
		pSouth.add(image_label);
		
		return pSouth;
	}

}
package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import manager.ManagerMain;

public class Pos_ManagerKey extends JFrame {
	//
	public Pos_ManagerKey() {
		JFrame frame = new JFrame("������ Ű");
		frame.getContentPane().setBackground(Color.WHITE);
		
		Font fontsize20 = new Font("���� ���", Font.PLAIN, 20);

		String storePath = "pos_image/store.png";
		Image storeImage = new ImageIcon(storePath).getImage();
		
		JLabel store = new JLabel(new ImageIcon(storeImage.getScaledInstance(300, 300, storeImage.SCALE_SMOOTH)));
		frame.add(store);

		JButton employeelogoutBtn = new JButton("���� �α׾ƿ�");
		employeelogoutBtn.setBackground(new Color(0x00769E));
		employeelogoutBtn.setFont(fontsize20);
		employeelogoutBtn.setBounds(570, 150, 280, 70);
		employeelogoutBtn.setForeground(Color.WHITE);
		frame.add(employeelogoutBtn);
		
		employeelogoutBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        new Pos_Login();
		        frame.setVisible(false); 
		    }
		});
		
		JButton managerBtn = new JButton("������ȭ������ �̵�");
		managerBtn.setFont(fontsize20);
		managerBtn.setBounds(570, 280, 280, 70);
		frame.add(managerBtn);
		
		
		managerBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        new ManagerMain();
		        frame.setVisible(false); 
		    }
		});
		
		
		store.setBounds(70, 120, 300, 300);
		
		
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(250, 50, 1000, 650);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Pos_ManagerKey();
	}
}

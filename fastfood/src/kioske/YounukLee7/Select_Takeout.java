package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import database.OjdbcConnection;
import kioske.pherkad0602.kiosk3;

public class Select_Takeout extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton button1 = new JButton("���� �Ļ�");
	JButton button2 = new JButton("���� �ֹ�");
	JLabel label = new JLabel("�������ּ���");
	CardLayout cardLayout = new CardLayout();
	
	public Select_Takeout() {
		
		String sql = "SELECT * FROM event_page";
		ArrayList<EventPage> event_page_list = new ArrayList<>();
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				) 
		{
				while (rs.next()) {
					 event_page_list.add(new EventPage(rs));
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(cardLayout);
        
        Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(pNorth);
			}
		});
        
        time.start();
        
        for (int i = 0; i < event_page_list.size(); i++) {
        	 pNorth.add(new ImageLabel(event_page_list.get(i).getSmall_event_page()));
		}
		
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		label.setFont(new Font("HY�߰��", Font.PLAIN, 50));
		label.setBounds(280, 50, 300,200);
		
		button1.setBounds(173, 200, 250, 350);
		button2.setBounds(463, 200, 250, 350);
		
		button1.setIcon(new ImageIcon("image/8.first.jpg"));
		button2.setIcon(new ImageIcon("image/8.second.jpg"));
		
		
		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new kiosk3();
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		button2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				new kiosk3();
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		pSouth.add(label);
		pSouth.add(button1);
		pSouth.add(button2);
		
		setLayout(null);
		setTitle("����Ļ� �Ǵ� ����");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Takeout();
	}
}

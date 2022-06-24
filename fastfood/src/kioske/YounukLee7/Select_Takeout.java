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
import kioske.YounukLee7.dbtablePocket.EventPage;

public class Select_Takeout extends JFrame{
	
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton storeOrder_button = new JButton("���� �Ļ� H");
	JButton takeout_button = new JButton("���� �ֹ� T");
	JLabel select_label = new JLabel("�������ּ���");
	CardLayout cardLayout = new CardLayout();
	String check;
	
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
		
		select_label.setFont(new Font("HY�߰��", Font.PLAIN, 50));
		select_label.setBounds(280, 50, 300,200);
		
		storeOrder_button.setBounds(173, 200, 250, 350);
		takeout_button.setBounds(463, 200, 250, 350);
		
		storeOrder_button.setIcon(new ImageIcon("image/8.first.jpg"));
		takeout_button.setIcon(new ImageIcon("image/8.second.jpg"));
		
		
		storeOrder_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				check = "H"; // String ����Ļ�
				
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		takeout_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				check = "T"; // String ���� �ֹ�
				
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		pSouth.add(select_label);
		pSouth.add(storeOrder_button);
		pSouth.add(takeout_button);
		
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

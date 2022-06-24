package kioske.YounukLee7.kioskeUI;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import database.OjdbcConnection;
import kioske.YounukLee7.ImageLabel;
import kioske.YounukLee7.Main_JPanel;
import kioske.YounukLee7.Select_Side_Drink;
import kioske.YounukLee7.Select_Takeout;
import kioske.YounukLee7.Start_Screen;
import kioske.YounukLee7.Sub_JPanel;
import kioske.YounukLee7.dbtablePocket.EventPage;

public class Start_Screen_kiosk extends JPanel{
	
	public Component Start_Screen_kiosk() {
		
		JPanel start_screen_panel = new JPanel();
		
		CardLayout cardLayout = new CardLayout();
		
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
		
		start_screen_panel.setBounds(0,0,900,1040);
		start_screen_panel.setLayout(cardLayout);
		
		// ȭ�� �� 3�ʸ��� �ѱ��
		Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(start_screen_panel);
			}
		});
		
		// ȭ�� ���� ����
		time.start();
		
		// ȭ��� (���� DB���� ������ �������� Big_event_page �κи� ������)
		for (int i = 0; i < event_page_list.size(); i++) {
			// Big_event_page�� get���� ��������
			start_screen_panel.add(new ImageLabel(event_page_list.get(i).getBig_event_page()));
		}
		
		start_screen_panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
				start_screen_panel.setVisible(false);
				Main_JPanel panel = new Main_JPanel();
				Sub_JPanel sub_JPanel = new Sub_JPanel();
				sub_JPanel.add(panel);
				//setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		
		return start_screen_panel;
	}

}

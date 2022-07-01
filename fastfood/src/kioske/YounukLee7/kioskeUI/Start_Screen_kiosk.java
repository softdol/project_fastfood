package kioske.YounukLee7.kioskeUI;

import java.awt.CardLayout;
import java.awt.Image;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import database.OjdbcConnection;
import kioske.YounukLee7.ImageLabel;
import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.dbtablePocket.EventPage;

public class Start_Screen_kiosk extends JPanel{
	
	public Start_Screen_kiosk(Main_JFrame screen) {
		
		setBounds(0,0,900,1040);
		setLayout(null);
		
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
		
		
		JPanel cardpanel = new JPanel();
		cardpanel.setBounds(0,0,900,1040);
		cardpanel.setLayout(cardLayout);
		add(cardpanel);
		
		// 화면 약 3초마다 넘기기
		Timer time = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(cardpanel);
			}
		});
		
		// 화면 시작 지점
		time.start();
		
		// 화면들 (위에 DB에서 가져온 정보에서 Big_event_page 부분만 꺼내기)
		for (int i = 0; i < event_page_list.size(); i++) {
			// Big_event_page만 get으로 가져오기
			
//			cardpanel.add(new ImageLabel(event_page_list.get(i).getBig_event_page()));
			
			
			JLabel image_label = new JLabel();
			image_label.setBounds(0,0,900,1040);
			
			ImageIcon icon = new ImageIcon(event_page_list.get(i).getBig_event_page());
			Image img = icon.getImage();
			Image eventimg = img.getScaledInstance(900, 1040, Image.SCALE_SMOOTH);
			ImageIcon eventicon = new ImageIcon(eventimg);
			image_label.setIcon(eventicon);
			
			cardpanel.add(image_label);
		}
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				// 포장, 매장식사 선택 화면으로 감
				screen.veiw_takeout();
				
			}  
		});
		
		
	}

}

package kioske.YounukLee7.kioskeUI;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import database.OjdbcConnection;
import kioske.YounukLee7.ImageLabel;
import kioske.YounukLee7.dbtablePocket.EventPage;

public class Select_Takeout_up {

	public Component Select_Takeout_up() {
		
		JPanel pNorth = new JPanel();
		
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
		
		return pNorth;
	}
}

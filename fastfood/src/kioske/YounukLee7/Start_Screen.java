package kioske.YounukLee7;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import database.OjdbcConnection;

public class Start_Screen extends JFrame{

	JPanel panel = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	public Start_Screen() {
		// DB���� �̹��� �������� EventPageŬ���� ���� ����
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
		
		// ȭ��� (���� DB���� ������ �������� Big_event_page �κи� ������)
		for (int i = 0; i < event_page_list.size(); i++) {
			// Big_event_page�� get���� ��������
			panel.add(new ImageLabel(event_page_list.get(i).getBig_event_page()));
		}
		
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

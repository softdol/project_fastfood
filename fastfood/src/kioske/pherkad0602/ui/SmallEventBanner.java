package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.action.MenuSelAction;
import kioske.pherkad0602.database.EventDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class SmallEventBanner extends JPanel{
	
	public Component SmallEventBanner(HomeMenuKiosk hMain, int i, Main_JFrame frame) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		String sql = "SELECT * FROM Event_Page";
		
		ArrayList<EventDatabase> evBanner = ReturnModel.eventList(sql);

	
		
		JButton evButton = new JButton();
		evButton.setBounds(5, 100+(i*150), 650, 145);
		evButton.setBackground(Color.white);
		evButton.setBorder(border);
		evButton.addActionListener(new MenuSelAction(hMain, evBanner.get(i).getMENU_IDX(),frame));
		ImageIcon icon = new ImageIcon(String.valueOf(evBanner.get(i).getSMALL_EVENT_PAGE()));		
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(680, 150, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel logo = new JLabel(changeIcon);
		evButton.add(logo);
		

		return evButton;
	
	}
	
	public static void main(String[] args) {
	}

}

package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuNamePanel extends JPanel {

	public Component MenuNamePanel() {
		
		JPanel mNamePanel = new JPanel();
		
		mNamePanel.setBounds(0, 100, 684, 100);
		mNamePanel.setLayout(null);
		
		JLabel mName = new JLabel("���� �޴� �̸�");
		
		mName.setBounds(20,10,500,80);
		mName.setFont(new Font("�ü�ü", Font.PLAIN,40));
		mNamePanel.add(mName);
		
		return mNamePanel;
	}
	
}

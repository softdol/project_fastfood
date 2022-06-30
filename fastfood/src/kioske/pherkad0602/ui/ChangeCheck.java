package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.kiosk7;
import kioske.pherkad0602.database.ReturnModel;

public class ChangeCheck {
	
	PayPanel pay;
	int idx;
	kiosk7 kiosk7;
	Main_JFrame frame;
	
	public ChangeCheck(kiosk7 kiosk7, int idx, String addCost) {
		this.idx = idx;
		this.frame = frame;
		
		JFrame checkFrame = new JFrame();
		checkFrame.setLayout(null);
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		
		JLabel label = new JLabel("메뉴를 변경하시겠습니까?");
		label.setBounds(60,10,300,50);
		label.setFont(new Font("궁서체", Font.BOLD,20));
		checkFrame.add(label);
		
		JButton btn1 = new JButton("네");
		btn1.setBounds(35,80,130,50);
		btn1.setFont(new Font("궁서체", Font.BOLD,20));
		btn1.setBackground(new Color(240,240,240));
		btn1.setBorder(border);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton performedButton = (JButton)e.getSource();
				kiosk7.setPrice(kiosk7, idx, addCost);		
				checkFrame.dispose();
			}
		});
		checkFrame.add(btn1);
		
		JButton btn2 = new JButton("아니오");
		btn2.setBounds(220,80,130,50);
		btn2.setFont(new Font("궁서체", Font.BOLD,20));
		btn2.setBackground(new Color(240,240,240));
		btn2.setBorder(border);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkFrame.dispose();
			}
		});
		checkFrame.add(btn2);
		
		checkFrame.setSize(400, 200);
		checkFrame.setLocationRelativeTo(null);
		checkFrame.getContentPane().setBackground(Color.white);
		checkFrame.setVisible(true);
		checkFrame.setResizable(false);
	

	}
	
}

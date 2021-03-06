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
import kioske.YounukLee7.Set_Option;
import kioske.YounukLee7.kioskeUI.Select_Set_down;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class OrderCheck extends JFrame{
	PayPanel pay;
	HomeMenuKiosk hMain;
	Main_JFrame frame;
	MenuDatabase menu;
	
	public OrderCheck(HomeMenuKiosk hMain, MenuDatabase menu, Main_JFrame frame) {
		
		this.hMain = hMain;
		this.frame = frame;
		this.menu = menu;
		
		JFrame checkFrame = new JFrame();
		checkFrame.setLayout(null);
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		
		JLabel label = new JLabel("장바구니에 추가하시겠습니까?");
		label.setBounds(60,10,300,50);
		label.setFont(new Font("궁서체", Font.BOLD,20));
		checkFrame.add(label);
		
		JButton btn1 = new JButton("네");
		btn1.setBounds(35,80,130,50);
		btn1.setFont(new Font("HY견고딕", Font.BOLD,20));
		btn1.setBackground(new Color(240,240,240));
		btn1.setBorder(border);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton performedButton = (JButton)e.getSource();
				String sql = "SELECT * FROM MENU_SET where MENU_IDX = ?";
				ArrayList<PsList> psList = new ArrayList<>();
				psList.add(new PsList('I', menu.getMenu_idx().toString()));
				System.out.println(ReturnModel.selConfirmP(sql, psList));
				if(ReturnModel.selConfirmP(sql, psList)) {
					new Set_Option(hMain, menu.getMenu_idx(),"s");
					//있을떄
				}else {	// 없을때
					hMain.setPrice(menu);
			
				}
				
				checkFrame.dispose();
			}
		});
		checkFrame.add(btn1);
		
		JButton btn2 = new JButton("아니오");
		btn2.setBounds(220,80,130,50);
		btn2.setFont(new Font("HY견고딕", Font.BOLD,20));
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

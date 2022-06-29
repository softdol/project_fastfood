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
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.ReturnModel;

public class OrderCheck extends JFrame{
	PayPanel pay;
	int idx;
	HomeMenuKiosk hMain;
	
	public OrderCheck(HomeMenuKiosk hMain, int idx) {
		this.idx = idx;
		this.hMain = hMain;
		
		JFrame checkFrame = new JFrame();
		checkFrame.setLayout(null);
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		
//		String sql = "SELECT * FROM Menu WHERE Menu_Category_IDX = 1";
//		ArrayList<MenuDatabase> menuList = ReturnModel.menuList(sql);
//		
//		String sql2 = "SELECT * FROME MENU_SET";
//		ArrayList<SetDatabase> setList = ReturnModel.setList(sql2);
//		
//		ArrayList orderList = new ArrayList();
		
		JLabel label = new JLabel("장바구니에 추가하시겠습니까?");
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
				performedButton.getName();
				System.out.println(idx + "안에");
				String sql = "SELECT * FROM MENU_SET where MENU_IDX = ?";
				ArrayList<PsList> psList = new ArrayList<>();
				psList.add(new PsList('I', String.valueOf(idx)));
				System.out.println(ReturnModel.selConfirmP(sql, psList));
				if(ReturnModel.selConfirmP(sql, psList)) {
					
					//있을떄
				}else {	// 없을때
					hMain.setPrice(idx);
			
				}
				
				
//				String name = performedButton.getName();
				
//				for(int i = 0; i < setList.size(); i++ ) {
//					
//					if (setList.get(i).getMENU_IDX().equals(name)) {
//						// 세트옵션페이지로 이동
//					} else {
//						//pay.view_menu(name);
//						//main.
//						System.out.println(name);
//					}	
//				}
				
			
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

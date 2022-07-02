package kioske.YounukLee7.kioskeUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import database.manager.Menu;
import database.model.PsList;
import kioske.YounukLee7.Last_JFrame;
import kioske.YounukLee7.Last_JPanel;
import kioske.YounukLee7.Main_JFrame;
import kioske.YounukLee7.cartButton.CartButton;
import kioske.YounukLee7.dbtablePocket.Order_list;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import manager.component.ManagerCP;

public class Cart_mid extends JPanel{
	
	
//	public void remove(ArrayList arrayList, Last_JFrame screen) {
//		main.remove(arrayList);
//		screen.add(new Cart_mid(screen));
//	}
	
	Cart_down down;
	Last_JPanel lPanel;
	Main_JFrame frame;
	
	public Cart_mid(Last_JPanel lPanel, Main_JFrame frame) {
		
		this.frame = frame;
		this.lPanel = lPanel;
		//setBackground(new Color(0XFFE7DF));
		setBackground(Color.BLACK);
		//setBounds(0,300,900,500);
		setBounds(0,300,900,500);
		setLayout(null);
//		// 이 패널의 layout이 null이기 때문에 아래 코드로 사이즈를 지정해주어야 한다
//		setPreferredSize(new Dimension(900, 2000));
		
		//CartButton cartButton;
		//int total = 0;
//		JPanel pCenter = new JPanel();
//		// 이 패널의 layout이 null이기 때문에 아래 코드로 사이즈를 지정해주어야 한다
//		pCenter.setPreferredSize(new Dimension(900, 2000));
//		pCenter.setBackground(new Color(0XFFE7DF));
//		pCenter.setBounds(0,300,900,2000);
//		pCenter.setLayout(null);
		
        // 매뉴 추가한 만큼
//		for (int i = 0; i < 3; i++) {
//			cartButton = new CartButton(main.get(i), pCenter, i);
////			total = total + cartButton.getSub_money();
//		}
		
		
		
				
		JPanel jPanel = new JPanel();
	//	jPanel.setPreferredSize(new Dimension(900, 2000));
		jPanel.setBackground(new Color(0XFFE7DF));
//		jPanel.setBounds(300,300,900,2000);
		jPanel.setLayout(null);
//		add(jPanel);
		
		
		for(int i = 0; i < frame.orderList.size(); i++) {
			Order_list o = frame.orderList.get(i);
//			jPanel.add(jp1);
			JPanel panel = new JPanel(); 
			panel.setBounds(0, 150 * i, 900, 150);
			panel.setBackground(new Color(0XFFE7DF));
			panel.setLayout(null);
			
			JButton cancel = new JButton("취소");
			cancel.setBounds(10, 50, 100, 50);
			cancel.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			cancel.setBackground(Color.black);
			cancel.setForeground(Color.white);
			int c = i;
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.orderList.remove(c);
				}
			});
			
			JLabel menuImg = new JLabel();
			menuImg.setBounds(120, 0, 150, 150);
			
			// arrayList에 주문이 한개일 때

			ImageIcon icon = new ImageIcon(o.getImg_path());
			Image img = icon.getImage();
			Image sideimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon sideicon = new ImageIcon(sideimg);
			menuImg.setIcon(sideicon);
			
//			
//			panel.add(minus);
//			panel.add(plus);//			
//			
			
			JLabel menuName = new JLabel(o.getMENU_NAME());
			menuName.setBounds(280, 0, 500, 60);
			menuName.setOpaque(true);
			menuName.setForeground(Color.black);
			menuName.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			menuName.setBackground(new Color(0XFFFF00));			
			panel.add(menuName);
			
			JLabel cnt_label = new JLabel(o.getORDER_QUANTITY().toString());
			cnt_label.setBounds(380, 80, 100, 50);
			cnt_label.setOpaque(true);
			cnt_label.setHorizontalAlignment(JLabel.CENTER);
			cnt_label.setForeground(Color.black);
			cnt_label.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			cnt_label.setBackground(new Color(0XFFFFFF));			
			panel.add(cnt_label);
			
	//		JLabel menuMoney = new JLabel(ManagerCP.viewWon(o.getORDER_PRICE()));
			JLabel menuMoney = new JLabel(ManagerCP.viewWon(o.getORDER_PRICE_TOTAL()));
			menuMoney.setFont(new Font("HY견고딕", Font.PLAIN, 30));
			menuMoney.setOpaque(true);
			menuMoney.setForeground(Color.RED);
			menuMoney.setBackground(new Color(0XFFE7DF));
			menuMoney.setBounds(600, 90, 200, 30);
		
			
			panel.add(menuMoney);
			
			JButton minus = new JButton("-");
			minus.setBounds(280, 80, 100, 50);
			minus.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			minus.setBackground(Color.black);
			minus.setForeground(Color.white);
			panel.add(minus);
//			int menuPrice = 0;
//			if (arrayList.size() == 1) {
//				menuPrice = menu.getMENU_PRICE();
//			}
//			int price = menuPrice;
			
			
			minus.addActionListener(new ActionListener() {
				
				int cnt = o.getORDER_QUANTITY();
				int idx = o.getMENU_IDX();
				int setIdx = o.getSET_IDX();
				@Override
				public void actionPerformed(ActionEvent e) {
					
				
					if (cnt>1) {
						--cnt;

					  	if(setIdx == 0){
					  		o.setORDER_QUANTITY(cnt);
					  		o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
					  		menuMoney.setText(o.getORDER_PRICE_TOTAL().toString());
					  		cnt_label.setText(o.getORDER_QUANTITY().toString());
					  		lPanel.SetPrice();
					  	} else {
					  		o.setORDER_QUANTITY(cnt);
					  		o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
					  		menuMoney.setText(String.valueOf((o.getORDER_PRICE_TOTAL() * (100- o.getMenu_sale()))/100));
					  		cnt_label.setText(o.getORDER_QUANTITY().toString());
					  		lPanel.SetPrice();

					  	}

					}
					
					
//					if (count == 1) {
//						cnt_label.setText(String.valueOf(count));
//						menuMoney.setText(price + "원");
//					}else {
//						count = count - 1;
//						cnt_label.setText(String.valueOf(count));
//						sub_money = sub_money - money;
//						menuMoney.setText(price + "원");
//					}
				}
			});
			
			JButton plus = new JButton("+");
			plus.setBounds(480, 80, 100, 50);
			plus.setFont(new Font("HY견고딕", Font.PLAIN, 20));
			plus.setBackground(Color.black);
			plus.setForeground(Color.white);
			panel.add(plus);
			plus.addActionListener(new ActionListener() {
				int cnt = o.getORDER_QUANTITY();
				int idx = o.getMENU_IDX();
				int setIdx = o.getSET_IDX();
				
				@Override
				public void actionPerformed(ActionEvent e) {
					++cnt;
					int sum = 0;
					for(int i = 0; i < frame.orderList.size(); i++) {
						sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
					}
			
					
				  	if(setIdx == 0){
				  		o.setORDER_QUANTITY(cnt);
				  		o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
				  		menuMoney.setText(o.getORDER_PRICE_TOTAL().toString());
				  		cnt_label.setText(o.getORDER_QUANTITY().toString());				 
				  		lPanel.SetPrice();

				  	} else {
				  		o.setORDER_QUANTITY(cnt);
				  		o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
				  		menuMoney.setText(String.valueOf((o.getORDER_PRICE_TOTAL() * (100- o.getMenu_sale()))/100));
				  		cnt_label.setText(o.getORDER_QUANTITY().toString());
				  		lPanel.SetPrice();
				  	}
					System.out.println(frame.orderList.get(c));

				}
//					count = count + 1;
//					cnt_label.setText(String.valueOf(count));
//					
//					sub_money = sub_money + money;
//					menuMoney.setText(String.valueOf(sub_money) + "원");
//				}
			});
	
			panel.add(cancel);
			panel.add(menuImg);

			jPanel.add(panel);
			
		//jPanel.add(new CartButton(main.get(i), pCenter, i));
		}
//		
//		JScrollPane scrollPane = new JScrollPane(jPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane.getVerticalScrollBar().setUnitIncrement(150);
//		scrollPane.setBounds(0, 0, 885, 500);
//		
		
		//
		
		JScrollPane scrollPane = new JScrollPane(jPanel);
		scrollPane.setBounds(0, 0, 884, 500);
		scrollPane.setBackground(Color.white);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
		//scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(865,150*frame.orderList.size());
				jPanel.setPreferredSize(size);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
			       scrollPane.getVerticalScrollBar().setValue(0);
			   }
			});
		add(scrollPane);

	}
	

}

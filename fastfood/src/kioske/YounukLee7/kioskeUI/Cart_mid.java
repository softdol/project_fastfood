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
		setBackground(Color.BLACK);
		setBounds(0,300,900,500);
		setLayout(null);
					
		JPanel jPanel = new JPanel();
		jPanel.setBackground(new Color(0XFFE7DF));
		jPanel.setLayout(null);
		int a = 0;
		int b = 0;
		for(int i = 0; i < frame.orderList.size(); i++) {
			Order_list o = frame.orderList.get(i);
			
			if(o.getSET_IDX() != 0 && o.getMENU_CATEGORY_IDX() == 1) {
			
				Order_list o2 = frame.orderList.get(i+1);
				Order_list o3 = frame.orderList.get(i+2);

				JPanel panel = new JPanel(); 
				panel.setBounds(0, 150 * a, 900, 150);
				panel.setBackground(new Color(0XFFE7DF));
				panel.setLayout(null);
				
				JButton cancel = new JButton("Ãë¼Ò");
				cancel.setName(String.valueOf(i));
				cancel.setBounds(10, 50, 100, 50);
				cancel.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
				cancel.setBackground(Color.black);
				cancel.setForeground(Color.white);
				cancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton performedButton = (JButton)e.getSource();
						String name = performedButton.getName();
					
						int nameInt = Integer.valueOf(name);
				
						frame.orderList.remove(nameInt);
						frame.orderList.remove(nameInt);
						frame.orderList.remove(nameInt);
						frame.veiw_Final_payment();
					}				
				});
				
				JLabel menuImg = new JLabel();
				menuImg.setBounds(120, 0, 150, 150);
				
				// arrayList¿¡ ÁÖ¹®ÀÌ ÇÑ°³ÀÏ ¶§
	
				ImageIcon icon = new ImageIcon(o.getImg_path());
				Image img = icon.getImage();
				Image sideimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				ImageIcon sideicon = new ImageIcon(sideimg);
				menuImg.setIcon(sideicon);
							
				JLabel menuName = new JLabel(o.getMENU_NAME() +"¼¼Æ® (" +
						o.getMENU_NAME() + ", " +
						o2.getMENU_NAME()+ ", "+
						o3.getMENU_NAME()+ ")");
				menuName.setBounds(280, 0, 500, 60);
				menuName.setOpaque(true);
				menuName.setForeground(Color.black);
				menuName.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 15));
				menuName.setBackground(new Color(0XFFFF00));			
				panel.add(menuName);
				
				JLabel cnt_label = new JLabel(o.getORDER_QUANTITY().toString());
				cnt_label.setBounds(380, 80, 100, 50);
				cnt_label.setOpaque(true);
				cnt_label.setHorizontalAlignment(JLabel.CENTER);
				cnt_label.setForeground(Color.black);
				cnt_label.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
				cnt_label.setBackground(new Color(0XFFFFFF));			
				panel.add(cnt_label);
				
				int saleMenuMoney = (o.getORDER_PRICE_TOTAL()+o2.getORDER_PRICE_TOTAL()+ o3.getORDER_PRICE_TOTAL())* (100-o.getMenu_sale())/100;
				System.out.println(o.getORDER_PRICE_TOTAL() + "  " + o2.getORDER_PRICE_TOTAL() + "  "+ o3.getORDER_PRICE_TOTAL());
				JLabel menuMoney = new JLabel(ManagerCP.viewWon(saleMenuMoney) +"¿ø");
				menuMoney.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
				menuMoney.setOpaque(true);
				menuMoney.setForeground(Color.RED);
				menuMoney.setBackground(new Color(0XFFE7DF));
				menuMoney.setBounds(600, 90, 200, 30);
		
				panel.add(menuMoney);
				
				JButton minus = new JButton("-");
				minus.setBounds(280, 80, 100, 50);
				minus.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
				minus.setBackground(Color.black);
				minus.setForeground(Color.white);
				panel.add(minus);

				
			
				minus.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						int cnt = o.getORDER_QUANTITY();

						if (cnt>1) {
							--cnt;
						  	o.setORDER_QUANTITY(cnt);
						  	o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
						  	o2.setORDER_QUANTITY(cnt);
						  	o2.setORDER_PRICE_TOTAL(cnt * o2.getORDER_PRICE());
						  	o3.setORDER_QUANTITY(cnt);
						  	o3.setORDER_PRICE_TOTAL(cnt * o3.getORDER_PRICE());			  	
							int saleMenuMoney = (o.getORDER_PRICE_TOTAL()+o2.getORDER_PRICE_TOTAL()+ o3.getORDER_PRICE_TOTAL())* (100-o.getMenu_sale())/100;
						  	menuMoney.setText(ManagerCP.viewWon(saleMenuMoney)+"¿ø");
						  	cnt_label.setText(o.getORDER_QUANTITY().toString());
						  	lPanel.SetPrice();
						  	
						}

					}
				});
				
				JButton plus = new JButton("+");
				plus.setBounds(480, 80, 100, 50);
				plus.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
				plus.setBackground(Color.black);
				plus.setForeground(Color.white);
				panel.add(plus);
				plus.addActionListener(new ActionListener() {
				
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int cnt = o.getORDER_QUANTITY();
						++cnt;
						
					 	o.setORDER_QUANTITY(cnt);
					  	o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
					  	o2.setORDER_QUANTITY(cnt);
					  	o2.setORDER_PRICE_TOTAL(cnt * o2.getORDER_PRICE());
					  	o3.setORDER_QUANTITY(cnt);
					  	o3.setORDER_PRICE_TOTAL(cnt * o3.getORDER_PRICE());
					  	int saleMenuMoney = (o.getORDER_PRICE_TOTAL()+o2.getORDER_PRICE_TOTAL()+ o3.getORDER_PRICE_TOTAL())* (100-o.getMenu_sale())/100;
					  	menuMoney.setText(ManagerCP.viewWon(saleMenuMoney)+"¿ø");
					  	cnt_label.setText(o.getORDER_QUANTITY().toString());
					  	lPanel.SetPrice();	

					}

				});
		
				panel.add(cancel);
				panel.add(menuImg);
				jPanel.add(panel);
				
				a++;
				b++;
			} else if(o.getSET_IDX() != 0 && o.getMENU_CATEGORY_IDX() != 1) {
					continue;
			} else {
				JPanel panel = new JPanel(); 
				panel.setBounds(0, 150 * a, 900, 150);
				panel.setBackground(new Color(0XFFE7DF));
				panel.setLayout(null);
				
				JButton cancel = new JButton("Ãë¼Ò");
				cancel.setName(String.valueOf(i));
				cancel.setBounds(10, 50, 100, 50);
				cancel.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
				cancel.setBackground(Color.black);
				cancel.setForeground(Color.white);
				cancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton performedButton = (JButton)e.getSource();
						String name = performedButton.getName();
						int nameInt = Integer.valueOf(name);
						
						frame.orderList.remove(nameInt);			
						frame.veiw_Final_payment();
					}
				});
				
				JLabel menuImg = new JLabel();
				menuImg.setBounds(120, 0, 150, 150);
				
				// arrayList¿¡ ÁÖ¹®ÀÌ ÇÑ°³ÀÏ ¶§
	
				ImageIcon icon = new ImageIcon(o.getImg_path());
				Image img = icon.getImage();
				Image sideimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				ImageIcon sideicon = new ImageIcon(sideimg);
				menuImg.setIcon(sideicon);
				
				JLabel menuName = new JLabel(o.getMENU_NAME());
				menuName.setBounds(280, 0, 500, 60);
				menuName.setOpaque(true);
				menuName.setForeground(Color.black);
				menuName.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 15));
				menuName.setBackground(new Color(0XFFFF00));			
				panel.add(menuName);
				
				JLabel cnt_label = new JLabel(o.getORDER_QUANTITY().toString());
				cnt_label.setBounds(380, 80, 100, 50);
				cnt_label.setOpaque(true);
				cnt_label.setHorizontalAlignment(JLabel.CENTER);
				cnt_label.setForeground(Color.black);
				cnt_label.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
				cnt_label.setBackground(new Color(0XFFFFFF));			
				panel.add(cnt_label);
								
				JLabel menuMoney = new JLabel(ManagerCP.viewWon(o.getORDER_PRICE_TOTAL())+"¿ø");
				menuMoney.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 30));
				menuMoney.setOpaque(true);
				menuMoney.setForeground(Color.RED);
				menuMoney.setBackground(new Color(0XFFE7DF));
				menuMoney.setBounds(600, 90, 200, 30);
		
				panel.add(menuMoney);
				
				JButton minus = new JButton("-");
				minus.setBounds(280, 80, 100, 50);
				minus.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
				minus.setBackground(Color.black);
				minus.setForeground(Color.white);
				panel.add(minus);
	
				minus.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						int cnt = o.getORDER_QUANTITY();
	
						if (cnt>1) {
							
							--cnt;
						  	o.setORDER_QUANTITY(cnt);
						  	o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
					  		menuMoney.setText(ManagerCP.viewWon((o.getORDER_PRICE_TOTAL() * (100- o.getMenu_sale()))/100)+"¿ø");
						  	cnt_label.setText(o.getORDER_QUANTITY().toString());
					  		lPanel.SetPrice();
						  	
						}
					}
				});
				
				JButton plus = new JButton("+");
				plus.setBounds(480, 80, 100, 50);
				plus.setFont(new Font("HY°ß°íµñ", Font.PLAIN, 20));
				plus.setBackground(Color.black);
				plus.setForeground(Color.white);
				panel.add(plus);
				plus.addActionListener(new ActionListener() {
			
					@Override
					public void actionPerformed(ActionEvent e) {
						int cnt = o.getORDER_QUANTITY();

						++cnt;
					  	o.setORDER_QUANTITY(cnt);
				 		o.setORDER_PRICE_TOTAL(cnt * o.getORDER_PRICE());
				 		menuMoney.setText(ManagerCP.viewWon((o.getORDER_PRICE_TOTAL() * (100- o.getMenu_sale()))/100)+"¿ø");
				  		cnt_label.setText(o.getORDER_QUANTITY().toString());
				  		lPanel.SetPrice();
					  	
					}
				});
		
				panel.add(cancel);
				panel.add(menuImg);
				jPanel.add(panel);
				
				a++;
				b++;
			}
	
		}

		JScrollPane scrollPane = new JScrollPane(jPanel);
		scrollPane.setBounds(0, 0, 884, 500);
		scrollPane.setBackground(Color.white);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);	
		//scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(865,150*b);
				jPanel.setPreferredSize(size);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
			       scrollPane.getVerticalScrollBar().setValue(0);
			   }
			});
		add(scrollPane);

	}
	

}

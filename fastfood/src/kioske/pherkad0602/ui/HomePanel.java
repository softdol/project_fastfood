package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.model.PsList;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.OrderDatabase;
import kioske.pherkad0602.database.ReturnModel;

public class HomePanel extends JPanel{

	public  HomePanel(HomeMenuKiosk hMain, Main_JFrame frame) {
		EmptyBorder border = new EmptyBorder(getInsets());
		
		String sql1 = "select menu_idx, sum(order_Quantity)from order_list GROUP BY menu_idx \r\n"
				+ "ORDER BY sum(order_Quantity)desc";
		ArrayList<OrderDatabase> order = ReturnModel.orderList(sql1);

		
		JPanel mainPanel = new JPanel();
		String sql2 = "SELECT * FROM Menu WHERE "
				+ "Menu_category_IDX = 1 and menu_use_flag = 'Y'"
				+ "and Menu_IDX IN (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
		
		ArrayList<PsList> psList = new ArrayList<>();
		for(int i = 0; i < 12; i++){
	  	  psList.add(new PsList('I', String.valueOf(order.get(i).getMenu_idx())));
		}
		ArrayList<MenuDatabase> menuList = ReturnModel.selMenuList1(sql2,psList);
		
		
		int a = menuList.size();
		
		JPanel eventTitlePanel = new JPanel();
		
		eventTitlePanel.setBounds(0, 0, 684, 100);
		eventTitlePanel.setLayout(null);
		eventTitlePanel.setBackground(Color.white);
		eventTitlePanel.setBorder(border);

		JLabel eventTitle = new JLabel("이벤트 메뉴");
		
		eventTitle.setBounds(20,10,500,80);
		eventTitle.setBackground(Color.white);
		eventTitle.setFont(new Font("궁서체", Font.PLAIN,40));
		eventTitlePanel.add(eventTitle);
		
		mainPanel.add(eventTitlePanel);
		
		
		mainPanel.setBounds(0, 100, 684, 800);
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.white);
		mainPanel.setBorder(border);
		
		SmallEventBanner seb = new SmallEventBanner();
	
		for(int i = 0; i <3; ++i) {
			
			mainPanel.add(seb.SmallEventBanner(hMain,i,frame));
		}
		
		JPanel titlePanel = new JPanel();
		
		titlePanel.setBounds(0, 550, 684, 100);
		titlePanel.setLayout(null);
		titlePanel.setBackground(Color.white);
		titlePanel.setBorder(border);
		
		JLabel title = new JLabel(" 인기 메뉴");
		
		title.setBounds(20,10,500,80);
		title.setBackground(Color.white);
		title.setFont(new Font("궁서체", Font.PLAIN,40));
		titlePanel.setBorder(border);
		titlePanel.add(title);
		
		mainPanel.add(titlePanel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBorder(border);
		
		
		Menu menu= new Menu(menuList, hMain, frame);
		menuPanel.add(menu);
		menuPanel.setBounds(0,650,684,550+(210*(a/3)+1));
		mainPanel.add(menuPanel);
		
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setBounds(0, 0, 684, 800);
		scrollPane.setBorder(border);
		Dimension size = new Dimension();
				size.setSize(600,650+(210*(a/3)+1));
		mainPanel.setPreferredSize(size);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			   public void run() {
			       scrollPane.getVerticalScrollBar().setValue(0);
			   }
			});
		add(scrollPane);
		setBounds(0, 200, 684, 800);
		setLayout(null);
		setBackground(Color.white);
		setBorder(border);
		
	}

}

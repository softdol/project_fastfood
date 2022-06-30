package manager.sales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import database.manager.Category;
import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import pos.Order;
import pos.Pos_PaymentPage;

public class SalesTable extends JPanel  {
	
	ManagerMain main;
	
	public SalesTable(ManagerMain main) {
		setLayout(null);
		setBounds(0,0,865,726);
		
		String[] strTitle = {"상품명", "수량", "단가", "가격"};
		
		DefaultTableModel dfTable = new DefaultTableModel(strTitle, 0);
		
		
		ArrayList<PsList> psList = new ArrayList<>();		
		ArrayList<Menu> menuList = ReturnModel.selMenuList("select * from menu", psList);
		
		Object[] orderF = new Object[4];
		
//		for(Menu m : menuList) {
//			System.out.println(m);
//		}
		
		ArrayList<Category> cateList = ReturnModel.categoryList();
		ArrayList<JComboBox<String>> cbList = new ArrayList<>();
		for(Category c: cateList) {			
			JComboBox<String> jCombo = new JComboBox<>();
			for(Menu m : menuList) {
				if(c.getMenu_category_idx() == m.getMenu_category()) {
					jCombo.addItem(m.getMenu_name());
				}
			}
			cbList.add(jCombo);
		}
		
		for(int i = 0; i < 15; i++) {
			Menu m = menuList.get((int)(Math.random() * menuList.size()));
			int cnt = (int)(Math.random() * 10);
			orderF[0] = m.getMenu_name();
			orderF[1] = cnt;
			orderF[2] = m.getMenu_price();
			orderF[3] = m.getMenu_price() * cnt;
			dfTable.addRow(orderF);
		}
		
		JComboBox<String> jcCount = new JComboBox<>();
		for(int i = 0; i < 50; i++) {
			jcCount.addItem(String.valueOf(i));
		}
		
		JTable orderTable = new JTable(dfTable);
		
		TableColumn column = orderTable.getColumnModel().getColumn(1);
		column.setCellEditor(new DefaultCellEditor(jcCount));
		
		orderTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(orderTable.getSelectedColumn() == 0) {
					System.out.println(orderTable.getSelectedRow());
				}
			}
		});
		
		orderTable.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(orderTable.getSelectedRow());
				System.out.println(orderTable.getSelectedColumn());
				
			}
			
		});
		
		
//		for(int j = 0; j < 100; j++) {
//			
//			String sqlIns = "insert into payment_list values(PAYMENT_LIST_SEQ.nextval, ?, ?, ?, sysdate - "+j+")";
//			ArrayList<PsList> pslist;
//			
//			for(int i = 0; i < 50; i++) {		
//				String[] ptype = {"P","S","B"};
//				String[] ntype = {"Y","N"};
//				int price = ((int)(Math.random() * 100) + 1) * 1000;
//				
//				pslist = new ArrayList<>();
//				pslist.add(new PsList('S', ptype[(int)(Math.random() * ptype.length)])); // P S B
//				pslist.add(new PsList('S', ntype[(int)(Math.random() * ntype.length)])); // N Y 
//				pslist.add(new PsList('I', String.valueOf(price)));
//				
//				//ManagerCP.viewPs(pslist);
//				OjdbcConnection.insert(sqlIns, pslist);
//			}
//			
//		}
//		ArrayList<PsList> pslist;
//		for(int j = 1; j < 200; j++) {
//			String sqlIns ="insert into calculate values(calculate_idx_seq.nextval";
//			sqlIns += ", sysdate -" + j + ", ?, sysdate - " + (j - 1) + ", ?, 'Y', ?)";
//			
//			int price = ((int)(Math.random() * 450 + 50) * 10000);
//			pslist = new ArrayList<>();
//			pslist.add(new PsList('S', main.mInfo.getMember_id()));
//			pslist.add(new PsList('S', main.mInfo.getMember_id()));
//			pslist.add(new PsList('I', String.valueOf(price)));
//			
////			System.out.println(sqlIns);
////			System.out.println(price);
//			//OjdbcConnection.insert(sqlIns, pslist);
//		}
		
		
		
		
		
		
//		orderTable.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				System.out.println("1");
//			}			
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				System.out.println("2");
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println("3");
//			}
//		});
		
		//orderTable.setFont(new Font("고딕체", Font.BOLD, 30));
		//orderTable.getColumnModel().getColumn(0).setPreferredWidth(500);
		orderTable.setRowHeight(30);
		//JTable.setBounds(0,0,200,200);
		JScrollPane jspn = new JScrollPane(orderTable);
		jspn.setBounds(0,0,400,500);
		
		
		
//		System.out.println(orderTable.getRowCount());
//		for(int i = 0; i < orderTable.getRowCount(); i++) {			
//			System.out.println(orderTable.getValueAt(i, 0));
//			
//			TableColumn column = orderTable.getColumnModel().getColumn(0);
//			column.setCellEditor(new DefaultCellEditor(cbList.get(i%4)));
//			//orderTable.setValueAt(new DefaultCellEditor(cbList.get(0)), i, 0);
//			//orderTable.setCellEditor(new DefaultCellEditor(cbList.get(0)));
//			//TableColumn column = orderTable.getColumnModel().getColumn(0);
//		}
		
		//TableColumn column = orderTable.getColumnModel().getColumn(0);
		//column.setCellEditor(new DefaultCellEditor(cbList.get(0)));
		
//		for(int idx=0; idx<orderTable.getRowCount(); idx++) {
//		    String rows = "";
//
//		    for(int cdx=0; cdx<orderTable.getColumnCount(); cdx++) {
//		    	 	
//		         Object val = orderTable.getValueAt(idx, cdx);
//
//		         rows = rows + " " + val;
//
//		    }
//
//		    System.out.println(rows);
//
//		}
		System.out.println(orderTable.getColumnModel()); 
		
		add(jspn);
		
		JButton btn = new JButton("포스 결제");
		
		btn.setBounds(400, 100, 120, 40);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Order> orderlist = new ArrayList<>();

				for (int i = 0; i < 3; i++) {
					int cnt = (int) (Math.random() * 10) + 1;
					int price = (int) (Math.random() * 5) + 1;
					price *= 1000;
					orderlist.add(new Order("햄버거", price, cnt, cnt * price));
				}
				
				new Pos_PaymentPageSe(orderlist, 'E');
				//new Pos_PaymentPageSe(orderlist, 'T');
				
			}
		});
		add(btn);
		
	}

}

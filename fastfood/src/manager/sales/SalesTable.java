package manager.sales;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import database.manager.Menu;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import pos.Order;

public class SalesTable extends JPanel  {
	
	ManagerMain main;
	Object[] orderF;
	DefaultTableModel dfTable;
	int setQuantity;
	JTable orderTable;
	ArrayList<Order> orderList;
	
	class ItemChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	    	   String item = (String)event.getItem();
	    	   String selQ = String.valueOf(orderTable.getValueAt(orderTable.getSelectedRow(), orderTable.getSelectedColumn()));
	    	   
	    	   if(!item.equals(selQ)) {
	    		   orderList.get(orderTable.getSelectedRow()).setTotalPrice(Integer.parseInt(item));
	    		   setOrderList();
	    	   }
	       }
	    }
	}
	
	public void setOrderList() {
		dfTable.setNumRows(0);
		for(int i = 0; i < orderList.size(); i++) {
			Order o = 	orderList.get(i);		
			
			orderF[0] = o.getMenu_name();
			orderF[1] = o.getOrder_quantity();
			orderF[2] = o.getOrder_price();
			orderF[3] = o.getOrder_price_total();
			dfTable.addRow(orderF);
		}
	}
	
	public SalesTable(ManagerMain main) {
		setLayout(null);
		setBounds(0,0,865,726);
		
		String[] strTitle = {"상품명", "수량", "단가", "가격"};
		
		dfTable = new DefaultTableModel(strTitle, 0);
		setQuantity = 0;
		orderList = new ArrayList<>();
		
		ArrayList<PsList> psList = new ArrayList<>();		
		ArrayList<Menu> menuList = ReturnModel.selMenuList("select * from menu", psList);
		
		orderF = new Object[4];
		
//		for(Menu m : menuList) {
//			System.out.println(m);
//		}
		
		// 콤보박스 추가
//		ArrayList<Category> cateList = ReturnModel.categoryList();
//		ArrayList<JComboBox<String>> cbList = new ArrayList<>();
//		for(Category c: cateList) {			
//			JComboBox<String> jCombo = new JComboBox<>();
//			for(Menu m : menuList) {
//				if(c.getMenu_category_idx() == m.getMenu_category()) {
//					jCombo.addItem(m.getMenu_name());
//				}
//			}
//			cbList.add(jCombo);
//		}
		for(int i = 0; i < 8; i++) {
			Menu m = menuList.get((int)(Math.random() * menuList.size()));
			int cnt = (int)(Math.random() * 5) + 1;
			orderList.add(new Order(m, cnt, 0));
		}
		
		setOrderList();
		
		JComboBox<String> jcCount = new JComboBox<>();
		for(int i = 1; i < 100; i++) {
			jcCount.addItem(String.valueOf(i));
		}
		jcCount.addItemListener(new ItemChangeListener());
//		jcCount.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println(1);
//			}
//		});
		
		orderTable = new JTable(dfTable);
		
		//컬럼 추가
		TableColumn column = orderTable.getColumnModel().getColumn(1);
		column.setCellEditor(new DefaultCellEditor(jcCount));
		
//		orderTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if(orderTable.getSelectedColumn() == 0) {
//					System.out.println(orderTable.getSelectedRow());
//				}
//			}
//		});
		
//		orderTable.addKeyListener(new KeyAdapter() {
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println(orderTable.getSelectedRow());
//				System.out.println(orderTable.getSelectedColumn());
//				
//			}
//			
//		});
		
		
		
//		orderTable.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				String selQ = String.valueOf(orderTable.getValueAt(orderTable.getSelectedRow(), orderTable.getSelectedColumn()));
//				System.out.println("keyTyped : " + selQ);
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
////				System.out.println("keyReleased : " + orderTable.getSelectedRow());
////				System.out.println("keyReleased : " + orderTable.getSelectedColumn());
//				String selQ = String.valueOf(orderTable.getValueAt(orderTable.getSelectedRow(), orderTable.getSelectedColumn()));
//				System.out.println("keyReleased : " + selQ);
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
////				System.out.println("keyPressed : " + orderTable.getSelectedRow());
////				System.out.println("keyPressed : " + orderTable.getSelectedColumn());
//				String selQ = String.valueOf(orderTable.getValueAt(orderTable.getSelectedRow(), orderTable.getSelectedColumn()));
//				System.out.println("keyPressed : " + selQ);
//			}
//		});
		
		
		
		
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
		//System.out.println(orderTable.getColumnModel()); 
		
		add(jspn);
		
		JButton btn2 = new JButton("테이블 데이트 추가");
		btn2.setBounds(400, 50, 200, 40);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				orderF[0] = "1";
				orderF[1] = "1";
				orderF[2] = "1";
				orderF[3] = "1";
				dfTable.addRow(orderF);
			}
		});
		
		add(btn2);
		JButton btn = new JButton("포스 결제");		
		
		btn.setBounds(400, 100, 120, 40);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Order> orderlist = new ArrayList<>();				
				ArrayList<PsList> psList = new ArrayList<>();
				String sql = "select * from menu";
				ArrayList<Menu> menuList = ReturnModel.selMenuList(sql, psList);
				for (int i = 0; i < 10; i++) {
					int cnt = (int) (Math.random() * 10) + 1;
					orderlist.add(new Order(menuList.get((int)(Math.random() * menuList.size())), cnt, (int)(Math.random() * 2)));
				}
				
				new Pos_PaymentPageSe(orderlist, 'E');
				//new Pos_PaymentPageSe(orderlist, 'T');
				
			}
		});
		add(btn);
		
	}

}

package pos;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MenuCheckPanel extends JPanel {
	
	public MenuCheckPanel() {
		
		setBounds(0,80,400,475);
		ArrayList<Order> orderList = new ArrayList<>();
		
		String[][] rowData = new String[orderList.size()][4];
		
		for(int i = 0; i < orderList.size(); i++) {
	         rowData[i][0] = orderList.get(i).getMenu();
	         rowData[i][1] = orderList.get(i).getMenunum().toString();
	         rowData[i][2] = orderList.get(i).getPrice().toString();
	         rowData[i][3] = orderList.get(i).getSumprice().toString();
	               
	      }
		
		String[] columnNames = {"메뉴", "수량", "단가", "합계"};
	      
	    JTable table = new JTable(rowData, columnNames);
	    table.setPreferredScrollableViewportSize(new Dimension(400,250));  
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	      
	    table.setRowHeight(40);
	    scrollPane.setBounds(0, 80, 400, 475);
	      
	    add(scrollPane);
	}
}

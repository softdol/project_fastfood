package manager.sales;

import javax.swing.JPanel;

import manager.ManagerMain;

public class SalesGraph extends JPanel {
	
	ManagerMain main;
	
	public SalesGraph(ManagerMain main) {
		
		this.main = main;
		main.setBounds(200,150,885,786);
		setLayout(null);
		setBounds(0,0,865,726);
		
		
		
	}
	
}

package manager.sales;

import javax.swing.JPanel;

import manager.ManagerMain;

public class SalesGraphView  extends JPanel{

	ManagerMain main;
	private SalesGraph panel = new SalesGraph();
	
	public SalesGraphView(ManagerMain main) {
		
		this.main = main;
		main.setBounds(400,150,885,786);
		setLayout(null);
		setBounds(0,0,865,726);
		
		main.setContentPane(panel);
		
	}
}

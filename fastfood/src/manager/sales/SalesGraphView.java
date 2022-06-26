package manager.sales;

import javax.swing.JPanel;

import manager.ManagerMain;

public class SalesGraphView  extends JPanel{

	ManagerMain main;
	
	public SalesGraphView(ManagerMain main) {		
		this.main = main;
		//main.setBounds(400,150,885,786);
		main.setSize(885,786);
		setLayout(null);
		setBounds(0,0,865,726);
		
		SalesGraph panel = new SalesGraph(this);
		
		//main.setContentPane(panel);
		add(panel);
		
	}
}

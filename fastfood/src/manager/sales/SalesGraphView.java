package manager.sales;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import database.manager.SaleMonth;
import manager.ManagerMain;
import manager.component.LabelWhite;
import manager.component.ManagerCP;

public class SalesGraphView  extends JPanel{
	
	ManagerMain main;
	Calendar cal;
	SalesTopCalendar topCalendar;
	SalesGraph panel;
	
	public void chgCalendar(String strEvene) {
		switch (strEvene) {			
			case "GNY":
				cal.add(Calendar.YEAR, +1);
				break;			
			case "GPY":
				cal.add(Calendar.YEAR, -1);
				break;
			
		}
		viewGraph();		
	}
	
	JPanel jpViewGraph = new JPanel();
	JPanel jpViewText = new JPanel(); 
	
	public void viewGraph() {
		DateFormat format = new SimpleDateFormat("yyyy");
		
		ManagerCP.reFresh(jpViewGraph);
		//panel = new SalesGraph(this);
		topCalendar = new SalesTopCalendar(this);
		topCalendar.setBounds(0, 0, 500, 50);
		
		topCalendar.jlViewDate.setText(format.format(cal.getTime()));
		
		setLayout(null);
		setBounds(0,0,965,826);
		
		panel = new SalesGraph(this);
		
		//add(panel);
		jpViewGraph.setLayout(null);
		jpViewGraph.setBounds(10,0,965,606);
		jpViewGraph.add(topCalendar);
		jpViewGraph.add(panel);
		
		add(jpViewGraph);
		
		
	}
	
	public void viewText(ArrayList<SaleMonth> saleViewList) {
		jpViewText = new JPanel();
		
		jpViewText.setLayout(new GridLayout(4, 14));
		jpViewText.setBounds(5, 636, 945, 140);

		jpViewText.add(new JButton(""));
		for(int i = 0; i < 12; i++) {
			JButton btn = new JButton((i+1) + "월");
			btn.setBounds(0, 0, 30, 30);
			jpViewText.add(btn);
		}
		JButton btnSum = new JButton("합 계");		
		jpViewText.add(btnSum);
		
		JLabel lblView1 = new JLabel("개 수", 0);
		lblView1.setBorder(new LineBorder(Color.BLACK));
		jpViewText.add(lblView1);		
		for(int i = 0; i < 12; i++) {
			LabelWhite lbl = new LabelWhite("");			
			jpViewText.add(lbl);
		}
		jpViewText.add(new LabelWhite(""));
		
		JLabel lblView2 = new JLabel("매 출", 0);		
		lblView2.setBorder(new LineBorder(Color.BLACK));
		jpViewText.add(lblView2);		
		long lSum = 0;
		for(int i = 0; i < 12; i++) {
			lSum += saleViewList.get(i).getlPrice();
			LabelWhite lbl = new LabelWhite(ManagerCP.viewWon(saleViewList.get(i).getlPrice()));
			jpViewText.add(lbl);
		}
		jpViewText.add(new LabelWhite(ManagerCP.viewWon(lSum)));
		
		JLabel lblView3 = new JLabel("객단가", 0);
		lblView3.setBorder(new LineBorder(Color.BLACK));
		jpViewText.add(lblView3);		
		for(int i = 0; i < 12; i++) {
			LabelWhite lbl = new LabelWhite("");			
			jpViewText.add(lbl);
		}
		jpViewText.add(new LabelWhite(""));
				
		add(jpViewText);
	}
	
	public SalesGraphView(ManagerMain main) {		
		this.main = main;
		//main.setBounds(400,150,885,786);
		main.setSize(975,886);
		cal = Calendar.getInstance();
		
		viewGraph();
	}
}

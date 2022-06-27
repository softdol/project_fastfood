package manager.sales;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import database.manager.ReturnModel;
import database.manager.SaleMonth;
import database.model.PsList;
import manager.component.ManagerCP;

public class SalesGraph extends JPanel {
	SalesGraphView main;
	
	ArrayList<SaleMonth> saleList;
	private int maxParice;
	
	public SalesGraph(SalesGraphView main) {
		this.main = main;
		setLayout(null);		
		setBounds(0, 0, main.getWidth(), main.getHeight());
		
		String sqlSelYear = "select TO_CHAR(calculate_in_date, 'mm'), sum(calculate_total_price) from calculate";
				sqlSelYear += " where TO_CHAR(calculate_in_date, 'yyyy') = ?";
				sqlSelYear += " group by TO_CHAR(calculate_in_date, 'mm') order by TO_CHAR(calculate_in_date, 'mm')";
		
		ArrayList<PsList> psList = new ArrayList<>();
		psList.add(new PsList('S', "2022"));
		
		saleList = ReturnModel.selCalculateYear(sqlSelYear, psList);
		//System.out.println(saleList.size());
		
//		saleList = new ArrayList<>();
//		for(int i = 0; i < 12; i++) {
//			saleList.add(new SaleMonth(i+1, (long)(Math.random() * 95000000)));
//		}
	}
	
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		int endRectY = super.getHeight() - 200;
		int endRectX = super.getWidth() - 40;
		int startRectX = 80;
		
		g.setColor(Color.BLUE);		
		g.drawRect(0, 0, endRectX, endRectY);
		g.setColor(Color.BLACK);
		g.drawLine(startRectX, 0, startRectX, endRectY);		
		g.drawLine(startRectX, endRectY, endRectX, endRectY);
		g.setColor(Color.GRAY);
		
		// 월별 선
		for(int i  = 0; i < 13; i++) {
			int lineX = startRectX + ((endRectX - startRectX + 50) / 12) * i;
			g.drawLine(lineX, 0, lineX, endRectY);
			
			JLabel jlMonth = new JLabel(String.valueOf((i + 1)));
			jlMonth.setBounds(lineX + 5, endRectY - 10, 40, 40);
			
			add(jlMonth);
			
			if(i < saleList.size()) {
				saleList.get(i).setiX(lineX);
				maxParice = (int)Math.max(maxParice, saleList.get(i).getlPrice());
			}
		}
		
		// 금액 선
		int maxNum = Math.max(maxParice, 100000000);
		int defaultParice = 10000000;
		int cntY;		
		if(maxNum % defaultParice > 0) {
			cntY = maxNum / defaultParice + 1;
		}else {
			cntY = maxNum / defaultParice;
		}
		
		for(int i = 0; i < cntY; i++) {
			int lineY = endRectY / cntY * (cntY - i) + (endRectY - (endRectY / cntY) * cntY);
			g.drawLine(startRectX, lineY, endRectX, lineY);
			
			JLabel jlWon = new JLabel(ManagerCP.viewWon(i * defaultParice),0);
			jlWon.setHorizontalAlignment(JLabel.RIGHT);
			jlWon.setBounds(startRectX - 85, lineY-20, 80, 40);
			
			add(jlWon);
		}
		
		g.setColor(Color.red);
		
		
		int saleCnt = saleList.size();
		
		for(int i = 0; i < saleList.size(); i++) {
			double pointY = saleList.get(i).getlPrice() / (float)defaultParice / cntY;			
			int temp = endRectY - (int)(endRectY * pointY);
			
			g.fillOval(saleList.get(i).getiX() - 3, temp, 6, 6);
			
			if(i < saleCnt - 1) {
				double pointYN = saleList.get(i + 1).getlPrice() / (float)defaultParice / cntY;			
				int tempN = endRectY - (int)(endRectY * pointYN);
				
				g.drawLine(saleList.get(i).getiX(), temp, saleList.get(i+1).getiX(), tempN);
			}
			
			JLabel jlThis = new JLabel(ManagerCP.viewWon(saleList.get(i).getlPrice()),0);
			if(i == 11) {
				jlThis.setBounds(saleList.get(i).getiX() - 40, temp -10, 80, 40);
			}else {
				jlThis.setBounds(saleList.get(i).getiX(), temp -10, 80, 40);
			}
			
			add(jlThis);
		}
		
	
	}
	
}

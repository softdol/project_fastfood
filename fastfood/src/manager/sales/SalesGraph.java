package manager.sales;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import database.manager.SaleMonth;
import manager.component.ManagerCP;

public class SalesGraph extends JPanel {
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);
		int endRectY = super.getHeight() - 200;
		int endRectX = super.getWidth();
		int startRectX = 80;
		
		ArrayList<SaleMonth> saleList = new ArrayList<>();
		for(int i = 0; i < 12; i++) {
			saleList.add(new SaleMonth(i+1, (long)(Math.random() * 90000000 + 10000000)));
		}
		
		//System.out.println("width : " + super.getWidth() + " , height : " + super.getHeight());
		g.setColor(Color.BLUE);		
		g.drawRect(0, 0, endRectX, endRectY);
		g.setColor(Color.BLACK);
		g.drawLine(startRectX, 0, startRectX, endRectY);		
		g.drawLine(startRectX, endRectY, endRectX, endRectY);
		g.setColor(Color.GRAY);
		// 월별 선
		for(int i  = 0; i < 12; i++) {
			int lineX = startRectX + ((endRectX - startRectX + 50) / 12) * (i + 1);
			g.drawLine(lineX, 0, lineX, endRectY);
			
			JLabel jlMonth = new JLabel(String.valueOf((i + 1)));
			jlMonth.setBounds(lineX - startRectX + 15, endRectY - 10, 40, 40);
			
			add(jlMonth);
			
			saleList.get(i).setiX(lineX);
		}
		
		// 금액 선
		int maxNum = 90000000;
		int cntY = 10;
		for(int i = 0; i < cntY; i++) {
			int lineY = endRectY / cntY * (cntY - i) + (endRectY - (endRectY / cntY) * cntY);
			//System.out.println(lineY);
			g.drawLine(startRectX, lineY, endRectX, lineY);
			
			JLabel jlWon = new JLabel(ManagerCP.viewWon(i * 10000000),0);
			//jlWon.setBorder(new LineBorder(Color.red));
			jlWon.setHorizontalAlignment(JLabel.RIGHT);
			jlWon.setBounds(startRectX - 85, lineY-20, 80, 40);
			
			add(jlWon);
		}
		
		System.out.println();
		System.out.println();
		
		g.setColor(Color.red);
		for(int i = 0; i < saleList.size(); i++) {
			int pointY = endRectY - (int)(saleList.get(i).getlPrice() / 100000 / (float)endRectY);
			int temp = (int)((double)endRectY / (saleList.get(i).getlPrice() / 10000) * endRectY);
			temp = endRectY - temp;
			System.out.println(saleList.get(i).getlPrice());			
			g.fillOval(saleList.get(i).getiX(), temp, 10, 10);
			
			JLabel jlThis = new JLabel(ManagerCP.viewWon(saleList.get(i).getlPrice()),0);
			jlThis.setBounds(saleList.get(i).getiX(), temp-20, 80, 40);
			
			add(jlThis);
		}
	
	}
	
}

package manager.sales;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manager.actionlistener.SaleActionListener;

public class SalesTopCalendar extends JPanel {
	
	SalesMain parent;
	public static JLabel jlViewDate;
	
	/**
	 * 매출 월별 탑 
	 * @param parent
	 */
	public SalesTopCalendar(SalesMain parent) {
		this.parent = parent;
		
		setLayout(null);
		setBounds(0, 5, parent.getWidth(), 50);
		JButton btnPrevY = new JButton("<<");
		btnPrevY.setBounds(20, 5, 50, 40);
		btnPrevY.addActionListener(new SaleActionListener(parent, "PY"));
		JButton btnPrevM = new JButton("<");		
		btnPrevM.setBounds(btnPrevY.getX() + btnPrevY.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnPrevM.addActionListener(new SaleActionListener(parent, "PM"));
		jlViewDate = new JLabel("", 0);
		jlViewDate.setBounds(btnPrevM.getX() + btnPrevM.getWidth() + 5, btnPrevY.getY(), 120, 40);
		jlViewDate.setOpaque(true);
		jlViewDate.setBackground(Color.white);
		jlViewDate.setFont(new Font("고딕체", Font.BOLD, 20));
		JButton btnNextM = new JButton(">");
		btnNextM.setBounds(jlViewDate.getX() + jlViewDate.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnNextM.addActionListener(new SaleActionListener(parent, "NM"));
		JButton btnNextY = new JButton(">>");
		btnNextY.setBounds(btnNextM.getX() + btnNextM.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnNextY.addActionListener(new SaleActionListener(parent, "NY"));
		
		JButton btnNow = new JButton("이번달");
		btnNow.setBounds(btnNextY.getX() + btnNextY.getWidth() + 5, btnPrevY.getY(), 80, 40);
		btnNow.addActionListener(new SaleActionListener(parent, "N"));
		
		
		add(btnPrevY);
		add(btnPrevM);
		add(jlViewDate);
		add(btnNextM);
		add(btnNextY);
		add(btnNow);

		// 오픈 마감 오픈취소 마감해지
		JButton btnOpen = new JButton("오픈");
		btnOpen.setBounds(btnNextY.getX() + btnNextY.getWidth() + 180, btnPrevY.getY(), 60, 40);
		JButton btnClose = new JButton("마감");
		btnClose.setBounds(btnOpen.getX() + btnOpen.getWidth() + 5, btnPrevY.getY(), 60, 40);
		JButton btnOpenC = new JButton("오픈취소");
		btnOpenC.setBounds(btnClose.getX() + btnClose.getWidth() + 5, btnPrevY.getY(), 90, 40);
		JButton btnCloseC = new JButton("마감해지");
		btnCloseC.setBounds(btnOpenC.getX() + btnOpenC.getWidth() + 5, btnPrevY.getY(), 90, 40);

		add(btnOpen);
		add(btnClose);
		add(btnOpenC);
		add(btnCloseC);
	}
	
	SalesGraphView parentG;
	
	/**
	 * 그래프 탑
	 * @param parentG
	 */
	public SalesTopCalendar(SalesGraphView parentG) {
		this.parentG = parentG;
		
		setLayout(null);
		setBounds(0, 5, parentG.getWidth(), 50);
		JButton btnPrevY = new JButton("<<");
		btnPrevY.setBounds(20, 5, 50, 40);
		btnPrevY.addActionListener(new SaleActionListener(parentG, "GPY"));
		jlViewDate = new JLabel("", 0);
		jlViewDate.setBounds(btnPrevY.getX() + btnPrevY.getWidth() + 5, btnPrevY.getY(), 120, 40);
		jlViewDate.setOpaque(true);
		jlViewDate.setBackground(Color.white);
		jlViewDate.setFont(new Font("고딕체", Font.BOLD, 20));
		JButton btnNextY = new JButton(">>");
		btnNextY.setBounds(jlViewDate.getX() + jlViewDate.getWidth() + 5, btnPrevY.getY(), 50, 40);
		btnNextY.addActionListener(new SaleActionListener(parentG, "GNY"));
		
//		JButton btnNow = new JButton("이번년");
//		btnNow.setBounds(btnNextY.getX() + btnNextY.getWidth() + 5, btnPrevY.getY(), 80, 40);
//		btnNow.addActionListener(new SaleActionListener(parentG, "N"));
		
		
		add(btnPrevY);
		add(jlViewDate);
		add(btnNextY);
//		add(btnNow);		
	}

}

package kioske.pherkad0602.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.BiConsumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kioske.YounukLee7.Last_JFrame;
import kioske.YounukLee7.Main_JFrame;
import kioske.pherkad0602.HomeMenuKiosk;
import kioske.pherkad0602.database.MenuDatabase;
import kioske.pherkad0602.database.ReturnModel;
import manager.component.ManagerCP;

public class PayPanel extends JPanel {
	public JLabel price;
	HomeMenuKiosk hMain;
	Main_JFrame frame;
	
	public PayPanel(HomeMenuKiosk hMain, Main_JFrame frame) {

		this.hMain = hMain;
		this.frame = frame;
		String sql = "SELECT * FROM Menu";
		ArrayList<MenuDatabase> menuList = ReturnModel.menuList(sql);
		
		setBounds(0, 800, 884, 200);
		setLayout(null);
		setBackground(new Color(0xdcdcdc));
		
		JLabel priceName = new JLabel("√— ¡÷πÆ ∞°∞› : " );
		priceName.setFont(new Font("HY∞ﬂ∞ÌµÒ", Font.PLAIN,40));
		priceName.setBounds(200,20,300,80);		
		add(priceName);
		
		price = new JLabel();
		int sum = 0;
		for(int i = 0; i < frame.orderList.size(); i ++) {
			
			if(frame.orderList.get(i).getSET_IDX()!= 0) {
				sum += (frame.orderList.get(i).getORDER_PRICE_TOTAL() * (100- frame.orderList.get(0).getMenu_sale()))/100;
			} else {
				sum += frame.orderList.get(i).getORDER_PRICE_TOTAL();
			}
		}
		price.setText(ManagerCP.viewWon(sum) +" ø¯");	
		price.setFont(new Font("HY∞ﬂ∞ÌµÒ", Font.PLAIN,40));
		price.setBounds(600,20,200,80);	
		price.setHorizontalAlignment(JLabel.RIGHT);

		add(price);
		
		String[] payMenu = {"√≥¿Ω¿∏∑Œ", "¡÷πÆ≥ªø™", "µµøÚ"};

			
		JButton payBtn1 = new JButton(payMenu[0]);
		payBtn1.setFont(new Font("HY∞ﬂ∞ÌµÒ", Font.PLAIN,40));
		payBtn1.setBounds(40, 100, 200, 80);
		payBtn1.setBackground(new Color(0xFFFFFF));
		payBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				hMain.orderReset();
			}
		});
		add(payBtn1);
		
		JButton payBtn2 = new JButton(payMenu[1]);
		payBtn2.setFont(new Font("HY∞ﬂ∞ÌµÒ", Font.PLAIN,40));
		payBtn2.setBounds(340, 100, 200, 80);
		payBtn2.setBackground(new Color(0xFFFFFF));
		payBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.veiw_Final_payment();
				//new Last_JFrame(frame, hMain);
			}
		});
		add(payBtn2);
		
		JButton payBtn3 = new JButton(payMenu[2]);
		payBtn3.setFont(new Font("HY∞ﬂ∞ÌµÒ", Font.PLAIN,40));
		payBtn3.setBounds(640, 100, 200, 80);
		payBtn3.setBackground(new Color(0xFFFFFF));
		add(payBtn3);
			
	
	}

	
	
}

package kioske.YounukLee7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import kioske.YounukLee7.cartButton.CartButton;
import kioske.pherkad0602.MainMenuKiosk;

public class Cart extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pSouth = new JPanel();

	ArrayList<JPanel> arrpanel = new ArrayList<>();
	
	JLabel logo = new JLabel("�ΰ�");
	JLabel order = new JLabel("�ֹ� ����");
	JLabel allpay = new JLabel("�� �����ݾ�");
	JLabel allmoney = new JLabel();
	JButton order_completed_button = new JButton("�ֹ� �Ϸ�");
	JButton more_order_button = new JButton("�߰� �ֹ�");
	int total = 0;
	CartButton cartButton;
	
	public Cart() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
        pCenter.setBackground(new Color(0XFFE7DF));
        pCenter.setBounds(0,300,900,2000);
        // �� �г��� layout�� null�̱� ������ �Ʒ� �ڵ�� ����� �������־�� �Ѵ�
        pCenter.setPreferredSize(new Dimension(900, 2000));
        pCenter.setLayout(null);
        
        
		pSouth.setBackground(new Color(0XFFF2DD));
		pSouth.setBounds(0,800,900,240);
		pSouth.setLayout(null);
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		order.setBounds(280, 50, 500, 200);
		order.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		
		                 // �Ŵ� �߰��� ��ŭ
		for (int i = 0; i < 5; i++) {
			cartButton = new CartButton(arrpanel, pCenter, i);
			total = total + cartButton.getSub_money();
		}
		
		
		JScrollPane scrollPane = new JScrollPane(pCenter, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(150);
		scrollPane.setBounds(0, 300, 885, 500);
		
		add(scrollPane);
		
		allpay.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		allpay.setOpaque(true);
		allpay.setForeground(Color.black);
		allpay.setBackground(new Color(0XFFF2DD));
		allpay.setBounds(40, 30, 180, 30);
		
		allmoney.setText(String.valueOf(total) + "��");
		allmoney.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		allmoney.setOpaque(true);
		allmoney.setForeground(Color.RED);
		allmoney.setBackground(new Color(0XFFF2DD));
		allmoney.setBounds(720, 30, 300, 30);
	
		order_completed_button.setForeground(new Color(0xFFFFFF));
		order_completed_button.setBackground(new Color(0XFF0000));
		order_completed_button.setFont(new Font("HY�߰��", Font.PLAIN, 40));
		order_completed_button.setBounds(450, 100, 380, 80);
		
		order_completed_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		more_order_button.setForeground(new Color(0xFFFFFF));
		more_order_button.setBackground(new Color(0X000000));
		more_order_button.setFont(new Font("HY�߰��", Font.PLAIN, 40));
		more_order_button.setBounds(40, 100, 380, 80);
		
		more_order_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		pNorth.add(logo);
		pNorth.add(order);
		
		pSouth.add(allpay);
		pSouth.add(allmoney);
		pSouth.add(order_completed_button);
		pSouth.add(more_order_button);
		
		add(pNorth);
		add(pSouth);
		
		setLayout(null);
		setTitle("��ٱ���");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Cart();
	}
}

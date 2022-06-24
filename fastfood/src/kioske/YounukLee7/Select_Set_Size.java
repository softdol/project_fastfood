package kioske.YounukLee7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Select_Set_Size extends JFrame{

	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JButton no_button = new JButton("�ƴϿ�");
	JButton yes_button = new JButton("��");
	JLabel label = new JLabel("<html><body style='text-align:center;'>700�� �߰��Ͻø� ���̵�� ���ᰡ"
							+ "<br />����������� ����˴ϴ�."
							+ "<p>���׷��̵� �Ͻðڽ��ϱ�?</body></html>");
	JLabel logo = new JLabel("�ΰ�");
	JLabel menu_name = new JLabel("��Ʈ �Ŵ� �̸�");
	// ��ǰ ����
	JLabel image_label = new JLabel();
	String check;
	
	public Select_Set_Size() {
		
		pNorth.setBackground(new Color(0XFFF2DD));
        pNorth.setBounds(0,0,900,300);
        pNorth.setLayout(null);
        
		pSouth.setBackground(new Color(0XFFE7DF));
		pSouth.setBounds(0,300,900,770);
		pSouth.setLayout(null);
		
		label.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		label.setBounds(210, 0, 500,200);
		
		logo.setBounds(50, 50, 200, 200);
		logo.setIcon(new ImageIcon("image/logo.png"));
		
		menu_name.setBounds(280, 50, 500, 200);
		menu_name.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		
		image_label.setBounds(260, 170, 360, 260);
		image_label.setIcon(new ImageIcon("image/set1.jpg"));
		
		no_button.setForeground(new Color(0xFFFFFF));
		no_button.setBackground(new Color(0x000000));
		no_button.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		no_button.setBounds(173, 450, 250, 60);
		
		yes_button.setForeground(new Color(0xFFFFFF));
		yes_button.setBackground(new Color(0xFF0000));
		yes_button.setFont(new Font("HY�߰��", Font.PLAIN, 30));
		yes_button.setBounds(463, 450, 250, 60);
		
		no_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				check = "M"; // String �Ϲ� ������
				
				new Select_Side_Drink();
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		yes_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){  
				check = "L"; // String ���� ������
				
				new Select_Side_Drink();
				setVisible(false); // ����ȭ������ �Ѿ�� ����ȭ�� �Ⱥ��̰� �ϱ�
			}  
		});
		
		add(pNorth, BorderLayout.NORTH);
		add(pSouth, BorderLayout.SOUTH);
		
		pNorth.add(logo);
		pNorth.add(menu_name);
		
		pSouth.add(no_button);
		pSouth.add(yes_button);
		pSouth.add(label);
		pSouth.add(image_label);
		
		setLayout(null);
		setTitle("�Ϲݼ�Ʈ �Ǵ� ������Ʈ");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Select_Set_Size();
	}
}

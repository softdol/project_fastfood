package manager.menu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import manager.component.LabelSub;
import manager.component.LabelTitle;

public class ManuMainPanel extends JPanel{
	
	public ManuMainPanel() {		
		//setBorder(new LineBorder(Color.red));
		setLayout(null);
		setBounds(0,0,1185,730);
		LabelTitle lblTitle = new LabelTitle("상품 등록");		
		//lblTitle.setBorder(new LineBorder(Color.BLACK));
		
		String[] s = {"햄버거","음료","사이드","디저트"};
		
		JComboBox cateList = new JComboBox(s);
		cateList.setBounds(lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20 , 80, 50);
		cateList.setFont(new Font("고딕체", Font.BOLD, 14));
		
		LabelSub lblName = new LabelSub("이름");
		lblName.setBounds(cateList.getX(), cateList.getY() + cateList.getHeight() + 20 , 50, 40);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("고딕체", Font.BOLD, 14));
		txtName.setBounds(lblName.getX() + lblName.getWidth() + 10, lblName.getY() , 120, 40);
		
		LabelSub lblPrice = new LabelSub("가격");
		lblPrice.setBounds(lblName.getX(), lblName.getY() + lblName.getHeight() + 20 , 50, 40);
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("고딕체", Font.BOLD, 14));
		txtPrice.setBounds(lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY() , 120, 40);
		
		
		LabelSub lblSale = new LabelSub("할인율");
		lblSale.setBounds(lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20 , 50, 40);
		JTextField txtSale = new JTextField();
		txtSale.setFont(new Font("고딕체", Font.BOLD, 14));
		txtSale.setBounds(lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY() , 120, 40);
		
		LabelSub lblImg = new LabelSub("이미지");
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, cateList.getY() , 300, 200);
		
		JButton btnInsert = new JButton("등록");
		btnInsert.setFont(new Font("고딕체", Font.BOLD, 14));
		btnInsert.setBounds(txtSale.getX() - 30, lblImg.getY() + lblImg.getHeight() + 40 , 80, 40);
		
		add(lblTitle);
		add(cateList);
		
		add(lblName);
		add(lblPrice);
		add(lblSale);
		
		add(txtName);
		add(txtPrice);
		add(txtSale);
		
		add(lblImg);
		
		add(btnInsert);
	}

}

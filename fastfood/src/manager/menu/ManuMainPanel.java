package manager.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.manager.Category;
import database.manager.ReturnModel;
import manager.actionlistener.ImgUpActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;

public class ManuMainPanel extends JPanel{
	
	private JLabel lblImg;
	private JTextField txtImgPath;
	
	
	public ManuMainPanel() {
		setLayout(null);
		setBounds(0,0,1185,730);
		LabelTitle lblTitle = new LabelTitle("��ǰ ���");
		
		String sql = "select * from menu_catagory";
		ArrayList<Category> cataList = ReturnModel.catagoryList(sql);

		JComboBox cateList = new JComboBox();
		for(Category c : cataList) {
			cateList.addItem(c.getMenu_category_name());
		}
		
		cateList.setBounds(lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20 , 80, 50);
		cateList.setFont(new Font("���ü", Font.BOLD, 14));
		
		LabelSub lblName = new LabelSub("�޴���");
		lblName.setBounds(cateList.getX(), cateList.getY() + cateList.getHeight() + 20 , 50, 40);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("���ü", Font.BOLD, 14));
		txtName.setBounds(lblName.getX() + lblName.getWidth() + 10, lblName.getY() , 120, 40);
		
		LabelSub lblPrice = new LabelSub("����");
		lblPrice.setBounds(lblName.getX(), lblName.getY() + lblName.getHeight() + 20 , 50, 40);
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("���ü", Font.BOLD, 14));
		txtPrice.setBounds(lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY() , 120, 40);
		
		
		LabelSub lblSale = new LabelSub("������");
		lblSale.setBounds(lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20 , 50, 40);
		JTextField txtSale = new JTextField();
		txtSale.setFont(new Font("���ü", Font.BOLD, 14));
		txtSale.setBounds(lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY() , 120, 40);
		
		lblImg = new JLabel("   �̹���");
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, cateList.getY() , 180, 200);
		
		JButton btnImg = new JButton("�̹��� ã��");
		btnImg.setBorder(new LineBorder(Color.BLACK));
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(this));
		
		JButton btnInsert = new JButton("���");
		btnInsert.setFont(new Font("���ü", Font.BOLD, 14));
		btnInsert.setBounds(txtSale.getX() - 30, btnImg.getY() + btnImg.getHeight() + 40 , 80, 40);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ī�װ� : " + cataList.get(cateList.getSelectedIndex()).getMenu_category_idx());
				System.out.println("�޴��� : " + txtName.getText());
				System.out.println("���� : " + txtPrice.getText());
				System.out.println("������ : " + txtSale.getText());
				System.out.println("�̹��� ��� : " + txtImgPath.getText());
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		add(lblTitle);
		add(cateList);
		
		add(lblName);
		add(lblPrice);
		add(lblSale);
		
		add(txtName);
		add(txtPrice);
		add(txtSale);
		
		add(btnImg);
		add(lblImg);
		add(txtImgPath);
		
		add(btnInsert);
		
	}
	
	public void viewUpImg(String path) {
		ImageIcon icon = new ImageIcon(path);
		txtImgPath.setText(path);
		
		Image img = icon.getImage();
		System.out.println("img path : " + txtImgPath.getText());
		Image cimg = img.getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),img.SCALE_SMOOTH);		
		lblImg.setIcon(new ImageIcon(cimg));
	}

}

package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.OjdbcConnection;
import database.model.PsList;
public class Pos_Login extends JFrame {
	
	Font f1,f2,f3;
	
	public Pos_Login() {
		f1 = new Font("휴먼모음T", Font.PLAIN, 30);
		f2 = new Font("Cooper Black", Font.PLAIN, 50);
		f3 = new Font("휴먼모음T", Font.PLAIN, 25);
		
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.white);
		
		
		
		JLabel login = new JLabel("< Login >");
		login.setBounds(420,130,500,100);
		login.setFont(f2);
		
		JLabel id = new JLabel("직원 ID : ");
		id.setBounds(400,200,200,100);
		id.setFont(f1);
		
		JTextField idField = new JTextField();
		idField.setBounds(530,233,130,35);
		idField.setFont(f3);
		
		JLabel pass = new JLabel("비밀번호 : ");
		pass.setBounds(400,200,200,200);
		pass.setFont(f1);
		
		
		JPasswordField passField = new JPasswordField();
		passField.setBounds(530,283,130,35);
		
		
		String storePath = "pos_image/store.png";
		Image storeImage = new ImageIcon(storePath).getImage();
		
		JLabel store = new JLabel(new ImageIcon(storeImage.getScaledInstance(300, 300, storeImage.SCALE_SMOOTH)));
		store.setBounds(70,120,300,300);
		
		
		
		String cheesePath = "pos_image/cheese.png";
		Image cheeseImage = new ImageIcon(cheesePath).getImage();
		
		JLabel cheese = new JLabel(new ImageIcon(cheeseImage.getScaledInstance(800, 300, cheeseImage.SCALE_SMOOTH)));
		cheese.setBounds(0,-130,800,550);
		
		
		JButton logBtn = new JButton("-- 로그인 -- ");
		logBtn.setBounds(400, 335, 260, 45);
		logBtn.setFont(f1);
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id_check = idField.getText();
				String pass_check = passField.getText();
				String sql = "SELECT member_pass, member_name FROM member_list WHERE member_id = ?";
				
				
				try (
					Connection conn = OjdbcConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);
				
				) {
					
					pstmt.setString(1, id_check);
					
					try(
							ResultSet rs = pstmt.executeQuery()) {
							if(rs.next()) {
								
								
								if(rs.getString(1).equals(pass_check)) {
									 JOptionPane.showMessageDialog(null, "[" + rs.getString(2) + "] " + "님으로 로그인이 되었습니다.");
									 new Pos_Burger();
									 
									 
									 
								} else {
									JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
								}
							} else {
								JOptionPane.showMessageDialog(null, "직원 ID가 올바르지 않습니다, 관리자에게 문의하세요");
							}
							
					}
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
	
		
	
		frame.add(login);
		frame.add(id);
		frame.add(pass);
		frame.add(logBtn);
		frame.add(idField);
		frame.add(passField);
		frame.add(store);	
	
		frame.add(cheese);
		
	
		frame.setTitle("Pos_Login");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(800, 550);
		frame.setLocationRelativeTo(null); // 가운데 정렬 
		frame.setVisible(true); 
		
		
		
				
	}
	
	public static void main(String[] args) {
		new Pos_Login();
	}
	
}

package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.OjdbcConnection;
import database.model.PsList;

public class LoginPanel extends JPanel {
	
	public LoginPanel(int width, int height) {
		//setBorder(new LineBorder(Color.RED));
		setLayout(null);
		setBounds(0, 0, width, height);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(30, 30, 50, 45);
		
		JLabel lblPass = new JLabel("패스워드");
		lblPass.setBounds(30, 85, 50, 45);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(90, 30, 80, 45);
		
		JPasswordField txtPassOn = new JPasswordField();
		txtPassOn.setBounds(90, 85, 80, 45);		
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.setBounds(180, 30, 80, 100);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<PsList> userInfo = new ArrayList<>();
				userInfo.add(new PsList('S', txtId.getText()));
				userInfo.add(new PsList('S', txtPassOn.getText()));				
				loginCheck(userInfo);
			}
		});		
		
		
		add(lblId);
		add(lblPass);
		add(txtId);
		add(txtPassOn);
		add(btnLogin);
		
						
	}
	
	public void loginCheck(ArrayList<PsList> userInfo) {		
		if(OjdbcConnection.selectOne("select * from member_list where member_id = ? and member_pass = ?", userInfo) != null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}

	
}

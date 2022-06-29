package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.manager.Member;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.component.ManagerCP;

public class LoginPanel extends JPanel {
	
	private ManagerMain main;

	JTextField txtId;
	JPasswordField txtPassOn;
	
	public LoginPanel(ManagerMain main) {
		this.main = main;
		
		setLayout(null);
		setBounds(0, 0, main.getWidth(), main.getHeight());
		
		JLabel lblId = new JLabel("���̵�");
		lblId.setBounds(30, 30, 50, 45);
		
		JLabel lblPass = new JLabel("�н�����");
		lblPass.setBounds(lblId.getX(), lblId.getY() + lblId.getHeight() + 10, 50, 45);
		
		txtId = new JTextField();
		txtId.setBounds(lblId.getX() + lblId.getWidth() + 10, lblId.getY(), 100, 45);
		txtId.requestFocus();
		
		txtPassOn = new JPasswordField();		
		txtPassOn.setBounds(txtId.getX(), lblPass.getY(), 100, 45);
		
//		txtId.setFocusTraversalKeysEnabled(false);
		txtPassOn.addKeyListener(new KeyAdapter() {			
			//Ű �Է½�
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)					
					loginCheck();
			}
		});
		
		JButton btnLogin = new JButton("�α���");
		btnLogin.setBounds(lblId.getX(), lblPass.getY() + lblPass.getHeight() + 20, lblId.getWidth() + txtId.getWidth() + 10, 45);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				loginCheck();
			}
			
		});
		
		add(lblId);
		add(lblPass);		
		add(txtId);
		add(txtPassOn);
		add(btnLogin);
		
		
		
//		Vector<Component> order = new Vector<>();
//		order.add(txtId);
//		order.add(txtPassOn);
//		order.add(btnLogin);		
//		ManagerFocusPolicy newPolicy = new ManagerFocusPolicy(order);
//		
//		setFocusTraversalPolicy(newPolicy);
		

		txtId.setText("admin");
		txtPassOn.setText("1234");
		login();
	}
	
	public void loginCheck() {
		
		if(txtId.getText().trim().length() == 0) {
			ManagerCP.viewError("���� ID �� �Է��� �ּ���.", "�Է� ����");
			txtId.requestFocus();
			return;
		}
		if(txtPassOn.getText().trim().length() == 0) {
			ManagerCP.viewError("��й�ȣ�� �Է��� �ּ���.", "�Է� ����");
			txtPassOn.requestFocus();
			return;
		}
		
		login();
	}
	
	public void login() {
		ArrayList<PsList> userInfo = new ArrayList<>();
		userInfo.add(new PsList('S', txtId.getText()));
		userInfo.add(new PsList('S', txtPassOn.getText()));				
		
		Member mInfo = ReturnModel.selMember("select * from member_list where member_id = ? and member_pass = ? and MEMBER_USE_FLAG = 'Y'", userInfo);
		
		if(mInfo != null) {
			setVisible(false);
			main.loginOn(mInfo);
		}else {
			JOptionPane.showMessageDialog(null, "ID �Ǵ� �н����尡 Ʋ���ϴ�.", "����",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	

		
		
		

	
}

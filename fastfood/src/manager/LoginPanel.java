package manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class LoginPanel extends JPanel {
	
	private ManagerMain main;
	
	public LoginPanel(ManagerMain main) {
		this.main = main;
		
		setLayout(null);
		setBounds(0, 0, main.getWidth(), main.getHeight());
		
		JLabel lblId = new JLabel("���̵�");
		lblId.setBounds(30, 30, 50, 45);
		
		JLabel lblPass = new JLabel("�н�����");
		lblPass.setBounds(30, 85, 50, 45);
		
		JTextField txtId = new JTextField();
		txtId.setBounds(90, 30, 80, 45);
		txtId.requestFocus();
		
		JPasswordField txtPassOn = new JPasswordField();		
		txtPassOn.setBounds(90, 85, 80, 45);
		
//		txtId.setFocusTraversalKeysEnabled(false);
//		txtId.addKeyListener(new KeyAdapter() {			
//			//Ű �Է½�
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println("keyPressed");
//				System.out.println(e.getKeyChar());
//				if(e.getKeyCode() == KeyEvent.VK_TAB)
//					txtPassOn.requestFocus();
//			}
//		});
		
		JButton btnLogin = new JButton("�α���");
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
		
		
		
//		Vector<Component> order = new Vector<>();
//		order.add(txtId);
//		order.add(txtPassOn);
//		order.add(btnLogin);		
//		ManagerFocusPolicy newPolicy = new ManagerFocusPolicy(order);
//		
//		setFocusTraversalPolicy(newPolicy);
		
		// �ڵ� �α��� �ӽ�
		ArrayList<PsList> loginInfo = new ArrayList<>();
		loginInfo.add(new PsList('S', "admin"));
		loginInfo.add(new PsList('I', "1234"));		
		loginCheck(loginInfo);
	}
	
	public void loginCheck(ArrayList<PsList> loginInfo) {
		
		Member mInfo = ReturnModel.selMember("select * from member_list where member_id = ? and member_pass = ?", loginInfo);
		
		if(mInfo != null) {
//			System.out.println("�α��� ����");
//			System.out.println(mInfo.getMember_id() + " : " + mInfo.getMember_name());
//			JOptionPane.showMessageDialog(null, "�α��� ���� [" + mInfo.getMember_id() + " : " + mInfo.getMember_name() + "]", "����",
//					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			main.loginOn(mInfo);
		}else {
//			System.out.println("�α��� ����");
			JOptionPane.showMessageDialog(null, "�α��� ����", "����",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	

		
		
		

	
}

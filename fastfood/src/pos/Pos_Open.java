package pos;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pos_Open extends JFrame {
	
	public Pos_Open() {
		super("POS");
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		JLabel login = new JLabel("Login");
		JButton button = new JButton("");
		
		panel.setLayout(new BorderLayout());
	
		panel.add(login);
		
		
		frame.add(panel);
		
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(250, 50, 1000, 700);
		setVisible(true);
				
	}
	
	public static void main(String[] args) {
		new Pos_Open();
	}
	
}

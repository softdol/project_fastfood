package manager.component;

import java.awt.Font;

import javax.swing.JTextField;

public class TextFieldSub extends JTextField {
	
	public TextFieldSub(String name,int x, int y) {
		super(name);
		setFont(new Font("∞ÌµÒ√º", Font.BOLD, 14));
		setBounds(x, y, 120, 40);
	}
	
	public TextFieldSub(String name,int x, int y, int w, int h) {
		super(name);
		setFont(new Font("∞ÌµÒ√º", Font.BOLD, 14));
		setBounds(x, y, w, h);
	}
	
	public TextFieldSub(String name) {
		super(name);
		setFont(new Font("∞ÌµÒ√º", Font.BOLD, 14));
	}

}

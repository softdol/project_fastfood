package manager.component;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class LabelSub extends JLabel  {
	
	public LabelSub(String name, int x, int y) {		
		super(name);
		setFont(new Font("????ü", Font.BOLD, 14));
		setBounds(x, y, 50, 40);
	}
	
	public LabelSub(String name, int x, int y, int w, int h) {		
		super(name);
		setFont(new Font("????ü", Font.BOLD, 14));
		setBounds(x, y, w, h);
	}
	
	public LabelSub(String name) {		
		super(name);
		setFont(new Font("????ü", Font.BOLD, 14));		
	}

}

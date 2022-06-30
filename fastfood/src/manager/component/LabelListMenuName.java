package manager.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelListMenuName extends JLabel {
	
	public LabelListMenuName(String name) {
		
		super(name);
		
		setHorizontalAlignment(CENTER);
		setOpaque(true);
		setFont(new Font("∞ÌµÒ√º", Font.BOLD, 14));
		setBackground(new Color(0xB82647));
		setForeground(new Color(0xFFFFFF));
		
	}

}

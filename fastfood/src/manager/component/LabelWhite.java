package manager.component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class LabelWhite extends JLabel {
	
	public LabelWhite(String val) {
		super(val);
		setOpaque(true);
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK));
		setFont(new Font("∞ÌµÒ√º", Font.PLAIN, 10));
		setHorizontalAlignment(RIGHT);
	}

}

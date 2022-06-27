package kioske.YounukLee7;

import javax.swing.JFrame;
import kioske.YounukLee7.kioskeUI.Cart_down;
import kioske.YounukLee7.kioskeUI.Cart_mid;
import kioske.YounukLee7.kioskeUI.Cart_up;

public class Cart extends JFrame{
	
	public Cart() {
		
		Cart_up up = new Cart_up();
		add(up);
		
		Cart_mid mid = new Cart_mid();
		add(mid);
        
		Cart_down down = new Cart_down();
		add(down);
		
		setLayout(null);
		setTitle("장바구니");
		setBounds(510,0,900,1040);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Cart();
	}
}

package manager.component;

import javax.swing.JPanel;

public class ManagerComp {
	
	public static void reFresh(JPanel jp) {
		
		jp.removeAll();
		jp.revalidate();
		jp.repaint();
		
	}

}

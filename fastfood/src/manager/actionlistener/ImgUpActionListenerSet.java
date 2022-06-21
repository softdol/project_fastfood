package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import manager.menu.MenuSetInsert;

public class ImgUpActionListenerSet implements ActionListener {
	
	JFileChooser chooser;
	MenuSetInsert main;

	public ImgUpActionListenerSet(MenuSetInsert main) {
		chooser = new JFileChooser();
		this.main = main;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Images",	// ���� �̸��� â�� ��µ� ���ڿ�
				"jpg","gif","png"			// ���� ���ͷ� ���Ǵ� Ȯ����. *.jpg, *.gif�� ������
			);
		chooser.setFileFilter(filter);// ���� �ٵ��α׿� ���� ���� ����
		
		// ���� �ٵ��α� ���
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {	// ����ڰ� â�� ������ �ݾҰų� ��� ��ư�� ���� ���
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.", "���",
					JOptionPane.WARNING_MESSAGE);
		}else {
			// ����ڰ� ������ �����ϰ�  "����" ��ư�� ���� ���
			String filePath = chooser.getSelectedFile().getPath();	// ���� ��� ���� �˾� �´�
			main.viewUpImg(filePath);
			
			//pack();	// �̹��� ũ�⿡ ���߾� �������� ũ�� ����				
		}
		
	}

}

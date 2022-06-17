package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImgUpActionListener implements ActionListener {
	
	JFileChooser chooser;
	
	public ImgUpActionListener() {
		// ���� ���̾�α� ����
		chooser = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images",	// ���� �̸��� â�� ��µ� ���ڿ�
				"jpg","gif"			// ���� ���ͷ� ���Ǵ� Ȯ����. *.jpg, *.gif�� ������
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
			//imageLabel.setIcon(new ImageIcon(filePath));	// ������ �ε��Ͽ� �̹��� ���̺� ����Ѵ�.
			
			System.out.println(filePath);
			
			File file = new File(filePath);
			
			System.out.println(file.getName());
			System.out.println(file.getParent());
			System.out.println(file.getUsableSpace());
			
			//fileSave(filePath, "", "1.");
			
			//pack();	// �̹��� ũ�⿡ ���߾� �������� ũ�� ����				
		}
		
	}

}

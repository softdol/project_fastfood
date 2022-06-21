package manager.actionlistener;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import manager.menu.MenuInsertPanel;
import manager.menu.MenuSetInsert;
import manager.menu.MenuSetModify;

public class ImgUpActionListener implements ActionListener {
	
	JFileChooser chooser;
	JPanel main;

	public ImgUpActionListener(JPanel main) {
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
			viewUpImg(filePath);
			
			//pack();	// �̹��� ũ�⿡ ���߾� �������� ũ�� ����				
		}
		
	}
	
	public void viewUpImg(String path) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		Image cimg;
		
		switch (main.getClass().getSimpleName().toString()) {
			case "MenuInsertPanel":
				MenuInsertPanel nInsPanel = (MenuInsertPanel)main;
				nInsPanel.txtImgPath.setText(path);
				
				cimg = img.getScaledInstance(nInsPanel.lblImg.getWidth(),nInsPanel.lblImg.getHeight(),img.SCALE_SMOOTH);		
				nInsPanel.lblImg.setIcon(new ImageIcon(cimg));
			break;
			case "MenuSetInsert":
				MenuSetInsert sInsPanel = (MenuSetInsert)main;
				sInsPanel.txtImgPath.setText(path);
				
				cimg = img.getScaledInstance(sInsPanel.lblImg.getWidth(),sInsPanel.lblImg.getHeight(),img.SCALE_SMOOTH);		
				sInsPanel.lblImg.setIcon(new ImageIcon(cimg));
			break;
			case "MenuSetModify":
				MenuSetModify sModPanel = (MenuSetModify)main;
				sModPanel.txtImgPath.setText(path);
				
				cimg = img.getScaledInstance(sModPanel.lblImg.getWidth(),sModPanel.lblImg.getHeight(),img.SCALE_SMOOTH);		
				sModPanel.lblImg.setIcon(new ImageIcon(cimg));
			break;
			
			
			
			default:
			break;
		}
		
		
	}

}

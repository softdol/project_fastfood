package manager.component;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.model.PsList;

public class ManagerCP {
	
	public static void fileSave(File file, String path, String name) {
		File copyfile = new File(path);	// ���丮�� ����
		
		if(!copyfile.exists()) {	// ������ �������� �ʴ´ٸ�
			copyfile.mkdir();
		}
		
		// ���� ����
		String filePath = path + "\\" + name;
		
		try(
			// ���� �б�
			FileInputStream fin = new FileInputStream(file);
			// ���� ����
			FileOutputStream fout = new FileOutputStream(filePath)				
				){
			int i = 0;	// ���� ���� ����Ʈ ���� üũ�ϱ� ���� ���� 
			byte[] buffer = new byte[1024];
			
			while((i = fin.read(buffer, 0, 1024)) != -1) {	// -1 = EOF(end of file)
				fout.write(buffer, 0, i);	// ���� ���� ��ŭ ���
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void viewError(String strVal, String strState) {
		
		JOptionPane.showMessageDialog(null, strVal, strState,
				JOptionPane.OK_OPTION);
		
	}
	
	public static void viewSuccess(String strVal, String strState) {
		
		JOptionPane.showMessageDialog(null, strVal, strState,
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static void reFresh(JPanel jp) {
		
		jp.removeAll();
		jp.revalidate();
		jp.repaint();
		
	}
	
	public static Image imgResize(String path, int width, int height) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage();
		
		return img.getScaledInstance(width,height,img.SCALE_SMOOTH);
	}
	
	public static void viewPs(ArrayList<PsList> ps) {
		for(PsList p : ps) {
			System.out.println("type = " + p.getType() + " : val = " + p.getVal());
		}
	}

}

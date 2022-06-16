package calculate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSet {

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
	
}

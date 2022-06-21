package manager.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ManagerCP {
	
	public static void fileSave(File file, String path, String name) {
		File copyfile = new File(path);	// 디렉토리의 정보
		
		if(!copyfile.exists()) {	// 폴더가 존재하지 않는다면
			copyfile.mkdir();
		}
		
		// 파일 복사
		String filePath = path + "\\" + name;
		
		try(
			// 파일 읽기
			FileInputStream fin = new FileInputStream(file);
			// 파일 쓰기
			FileOutputStream fout = new FileOutputStream(filePath)				
				){
			int i = 0;	// 파일 읽은 바이트 수를 체크하기 윈한 변수 
			byte[] buffer = new byte[1024];
			
			while((i = fin.read(buffer, 0, 1024)) != -1) {	// -1 = EOF(end of file)
				fout.write(buffer, 0, i);	// 읽은 개수 만큼 출력
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void viewError(String strVal, String strState) {
		
		JOptionPane.showMessageDialog(null, strVal, strState,
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static void viewSuccess(String strVal, String strState) {
		
		JOptionPane.showMessageDialog(null, strVal, strState,
				JOptionPane.OK_OPTION);
		
	}
	
	public static void reFresh(JPanel jp) {
		
		jp.removeAll();
		jp.revalidate();
		jp.repaint();
		
	}

}

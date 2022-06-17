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
		// 파일 다이얼로그 생성
		chooser = new JFileChooser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images",	// 파일 이름에 창에 출력될 문자열
				"jpg","gif"			// 파일 필터로 사용되는 확장자. *.jpg, *.gif만 나열됨
			);
		chooser.setFileFilter(filter);// 파일 다디얼로그에 파일 필터 설정
		
		// 파일 다디얼로그 출력
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {	// 사용자가 창을 강제로 닫았거나 취소 버튼을 누른 경우
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",
					JOptionPane.WARNING_MESSAGE);
		}else {
			// 사용자가 파일을 선택하고  "열기" 버튼을 누른 경우
			String filePath = chooser.getSelectedFile().getPath();	// 파일 경로 명을 알아 온다
			//imageLabel.setIcon(new ImageIcon(filePath));	// 파일을 로딩하여 이미지 레이블에 출력한다.
			
			System.out.println(filePath);
			
			File file = new File(filePath);
			
			System.out.println(file.getName());
			System.out.println(file.getParent());
			System.out.println(file.getUsableSpace());
			
			//fileSave(filePath, "", "1.");
			
			//pack();	// 이미지 크기에 맞추어 프레임의 크기 조절				
		}
		
	}

}

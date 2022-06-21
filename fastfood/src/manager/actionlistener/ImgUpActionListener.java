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
				"Images",	// 파일 이름에 창에 출력될 문자열
				"jpg","gif","png"			// 파일 필터로 사용되는 확장자. *.jpg, *.gif만 나열됨
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
			viewUpImg(filePath);
			
			//pack();	// 이미지 크기에 맞추어 프레임의 크기 조절				
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

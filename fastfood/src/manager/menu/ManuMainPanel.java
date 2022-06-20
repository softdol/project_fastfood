package manager.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import database.OjdbcConnection;
import database.manager.Category;
import database.manager.ReturnModel;
import database.model.PsList;
import manager.ManagerMain;
import manager.actionlistener.ImgUpActionListener;
import manager.component.LabelSub;
import manager.component.LabelTitle;

public class ManuMainPanel extends JPanel{
	
	private JLabel lblImg;
	private JTextField txtImgPath;
	private ManagerMain main;
	
	public ManuMainPanel(ManagerMain main) {
		this.main = main;
		setLayout(null);
		setBounds(0,0,1185,730);
		LabelTitle lblTitle = new LabelTitle("상품 등록");
		
		String sql = "select * from menu_catagory";
		ArrayList<Category> cataList = ReturnModel.catagoryList(sql);

		JComboBox cateList = new JComboBox();
		cateList.addItem("--대분류--");
		for(Category c : cataList) {
			cateList.addItem(c.getMenu_category_name());
		}
		
		cateList.setBounds(lblTitle.getX(), lblTitle.getY() + lblTitle.getHeight() + 20 , 80, 50);
		cateList.setFont(new Font("고딕체", Font.BOLD, 14));
		
		LabelSub lblName = new LabelSub("메뉴명");
		lblName.setBounds(cateList.getX(), cateList.getY() + cateList.getHeight() + 20 , 50, 40);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("고딕체", Font.BOLD, 14));
		txtName.setBounds(lblName.getX() + lblName.getWidth() + 10, lblName.getY() , 120, 40);
		
		LabelSub lblPrice = new LabelSub("가격");
		lblPrice.setBounds(lblName.getX(), lblName.getY() + lblName.getHeight() + 20 , 50, 40);
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("고딕체", Font.BOLD, 14));
		txtPrice.setBounds(lblPrice.getX() + lblPrice.getWidth() + 10, lblPrice.getY() , 120, 40);
		
		
		LabelSub lblSale = new LabelSub("할인율");
		lblSale.setBounds(lblPrice.getX(), lblPrice.getY() + lblPrice.getHeight() + 20 , 50, 40);
		JTextField txtSale = new JTextField("0");
		txtSale.setFont(new Font("고딕체", Font.BOLD, 14));
		txtSale.setBounds(lblSale.getX() + lblSale.getWidth() + 10, lblSale.getY() , 120, 40);
		
		lblImg = new JLabel("   이미지");
		lblImg.setBorder(new LineBorder(Color.BLACK));
		lblImg.setBounds(txtSale.getX() + txtSale.getWidth() + 30, cateList.getY() , 180, 200);
		
		JButton btnImg = new JButton("이미지 찾기");
		btnImg.setBorder(new LineBorder(Color.BLACK));
		btnImg.setBounds(lblImg.getX() + 30, lblImg.getY() + lblImg.getHeight() + 20 , 100, 40);
		btnImg.addActionListener(new ImgUpActionListener(this));
		
		JButton btnInsert = new JButton("등록");
		btnInsert.setFont(new Font("고딕체", Font.BOLD, 14));
		btnInsert.setBounds(txtSale.getX() - 30, btnImg.getY() + btnImg.getHeight() + 40 , 80, 40);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean inputChk = true;
				
				if(cateList.getSelectedIndex() == 0) {					
					viewError("대분류를 선택해 주세요.","입력오류");					
					cateList.requestFocus();
					inputChk = false;
					return;
				}
				if(txtName.getText().trim().length() == 0) {					
					viewError("메뉴명을 입력해 주세요.","입력오류");
					txtName.requestFocus();
					inputChk = false;
					return;
				}
				if(txtPrice.getText().trim().length() == 0) {
					viewError("가격을 입력해 주세요.","입력오류");
					txtPrice.requestFocus();
					inputChk = false;
					return;
				}
				if(txtSale.getText().trim().length() == 0) {
					viewError("할인율을 입력해 주세요.","입력오류");
					txtSale.requestFocus();
					inputChk = false;
					return;
				}
				if(txtImgPath.getText().trim().length() == 0) {
					viewError("이미지가 입력 되지 않았습니다.","입력오류");
					inputChk = false;
					return;
				}
				if(!main.mInfo.getLogin()) {
					viewError("담당자 정보가 없습니다.","로그인 오류");
					inputChk = false;
					return;
				}
				
				if(inputChk) {				
					String sql = "iinsert into menu values(menu_idx_seq.nextval, ";
							sql += " ?, ?, ?, ?, ?, 'Y', sysdate, ?)";
					ArrayList<PsList> psList = new ArrayList<>();
					psList.add(new PsList('I', String.valueOf(cataList.get(cateList.getSelectedIndex() + 1).getMenu_category_idx())));
					
					String[] fileName = txtImgPath.getText().split("\\.");
					String fileExt = "";
					String filePath = "imgUpload";
					if(fileName.length > 1) {					
						//System.out.println(System.currentTimeMillis() + "." + fileName[1]);
						fileExt = System.currentTimeMillis() + "." + fileName[1];
						fileSave(new File(txtImgPath.getText()), filePath,fileExt);
					}
					
					psList.add(new PsList('S',filePath + "\\" + fileExt));
					psList.add(new PsList('S',txtName.getText()));
					psList.add(new PsList('I',txtPrice.getText()));
					psList.add(new PsList('I',txtSale.getText()));
					psList.add(new PsList('S',main.mInfo.getMember_id()));
					//psList.add(new PsList('S',"localadmin"));
					
					String sqi_menuIns = "insert into menu (MENU_IDX, MENU_CATEGORY_IDX, IMG_BIG_PATH, MENU_NAME, MENU_PRICE, MENU_SALE, MENU_USE_FLAG, MENU_IN_DATE, MENU_IN_ID ) ";
						   sqi_menuIns += "values(MENU_IDX_SEQ.nextval, ?, ?, ?, ?, ?, 'Y', sysdate, ?)";
				    //System.out.println();   
					if(OjdbcConnection.insert(sqi_menuIns, psList)) {
						viewSuccess("상품이 등록 되었습니다.","상품등록");
					}else{
						viewError("상품 등록에 실패했습니다.","실패");
					};
					
//					for(PsList p : psList) {
//						System.out.println(p.getType() + " : " + p.getVal());
//					}
				}
				//System.out.println("카테고리 : " + cataList.get(cateList.getSelectedIndex()).getMenu_category_idx());
				//System.out.println("메뉴명 : " + txtName.getText());
				//System.out.println("가격 : " + txtPrice.getText());
				//System.out.println("할인율 : " + txtSale.getText());
				//System.out.println("이미지 경로 : " + txtImgPath.getText());
			}
		});
		
		txtImgPath = new JTextField();
		txtImgPath.setVisible(false);
		
		add(lblTitle);
		add(cateList);
		
		add(lblName);
		add(lblPrice);
		add(lblSale);
		
		add(txtName);
		add(txtPrice);
		add(txtSale);
		
		add(btnImg);
		add(lblImg);
		add(txtImgPath);
		
		add(btnInsert);
		
	}
	
	public void viewUpImg(String path) {
		ImageIcon icon = new ImageIcon(path);
		txtImgPath.setText(path);
		
		Image img = icon.getImage();
		System.out.println("img path : " + txtImgPath.getText());
		Image cimg = img.getScaledInstance(lblImg.getWidth(),lblImg.getHeight(),img.SCALE_SMOOTH);		
		lblImg.setIcon(new ImageIcon(cimg));
	}
	
	public void fileSave(File file, String path, String name) {
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
	
	public void viewError(String strVal, String strState) {
		
		JOptionPane.showMessageDialog(null, strVal, strState,
				JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void viewSuccess(String strVal, String strState) {
		
		JOptionPane.showMessageDialog(null, strVal, strState,
				JOptionPane.OK_OPTION);
		
	}

}

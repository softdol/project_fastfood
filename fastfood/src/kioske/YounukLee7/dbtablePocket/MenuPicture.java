package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuPicture {

	private String img_big_path;
	private String set_img_path;
	
	public MenuPicture(ResultSet rs) throws SQLException {
		set_img_path = rs.getString(1);
		img_big_path = rs.getString(2);
	}
	
	
	public String getImg_big_path() {
		return img_big_path;
	}
	
	public String getSet_img_path() {
		return set_img_path;
	}
}

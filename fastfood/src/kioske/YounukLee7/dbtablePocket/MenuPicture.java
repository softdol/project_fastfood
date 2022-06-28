package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuPicture {

	private Integer set_idx;
	private String img_big_path;
	private String set_img_path;
	private String menu_name;
	private String set_name;
	
	public MenuPicture(ResultSet rs) throws SQLException {
		set_img_path = rs.getString("set_img_path");
		img_big_path = rs.getString("img_big_path");
		menu_name = rs.getString("menu_name");
		set_name = rs.getString("set_name");
		set_idx = rs.getInt("set_idx");
	}
	
	
	public String getImg_big_path() {
		return img_big_path;
	}
	
	public String getSet_img_path() {
		return set_img_path;
	}
	
	public String getMenu_name() {
		return menu_name;
	}
	
	public String getSet_name() {
		return set_name;
	}
	
	public Integer getSet_idx() {
		return set_idx;
	}
}

package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu {

	private Integer menu_idx;    
	private Integer menu_category;    
	private String img_big_path; 
	private String menu_name; 
	private Integer menu_price; 
	private Integer menu_sale;    
	private String menu_use;  
	private Date  menu_in_date;         
	private String menu_in_id; 
	private Date menu_mod_date;         
	private String menu_mod_id;
	
	public Integer getMenu_idx() {
		return menu_idx;
	}

	public Integer getMenu_category() {
		return menu_category;
	}

	public void setMenu_category(Integer menu_category) {
		this.menu_category = menu_category;
	}

	public String getImg_big_path() {
		return img_big_path;
	}

	public void setImg_big_path(String img_big_path) {
		this.img_big_path = img_big_path;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public Integer getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(Integer menu_price) {
		this.menu_price = menu_price;
	}

	public Integer getMenu_sale() {
		return menu_sale;
	}

	public void setMenu_sale(Integer menu_sale) {
		this.menu_sale = menu_sale;
	}

	public String getMenu_use() {
		return menu_use;
	}

	public void setMenu_use(String menu_use) {
		this.menu_use = menu_use;
	}

	public Date getMenu_in_date() {
		return menu_in_date;
	}

	public String getMenu_in_id() {
		return menu_in_id;
	}
	
	public Date getMenu_mod_date() {
		return menu_mod_date;
	}

	public void setMenu_mod_id(String menu_mod_id) {
		this.menu_mod_id = menu_mod_id;
	}
	
	public Menu(ResultSet rs) throws SQLException {
		this.menu_idx = rs.getInt(1);    
		this.menu_category = rs.getInt(1);
		this.img_big_path = rs.getString(1);
		this.menu_name = rs.getString(1);
		this.menu_price = rs.getInt(1);
		this.menu_sale = rs.getInt(1);
		this.menu_use = rs.getString(1);
		this.menu_in_date = rs.getDate(1);
		this.menu_in_id = rs.getString(1);
		this.menu_mod_date = rs.getDate(1);
		this.menu_mod_id = rs.getString(1);
	}
}
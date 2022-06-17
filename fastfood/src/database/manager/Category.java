package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
	private Integer menu_category_idx;	
	private String menu_category_name;
	private Date menu_category_in_date;
	
	public Category(ResultSet rs) throws SQLException {
		this.menu_category_idx = rs.getInt(1);	
		this.menu_category_name = rs.getString(2);
		this.menu_category_in_date = rs.getDate(3);
	}

	public Integer getMenu_category_idx() {
		return menu_category_idx;
	}

	public String getMenu_category_name() {
		return menu_category_name;
	}

	public Date getMenu_category_in_date() {
		return menu_category_in_date;
	}
	
	
}

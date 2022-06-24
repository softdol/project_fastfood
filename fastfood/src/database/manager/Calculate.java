package database.manager;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Calculate {
	private Integer calculate_idx;    
	private Date 	calculate_in_date;         
	private String 	calculate_in_id; 
	private Date 	calculate_out_date;         
	private String 	calculate_out_id; 
	private String 	calculate_close;  
	private Integer calculate_total_price;
	
	public Calculate(ResultSet rs) throws SQLException {
		this.calculate_idx			= rs.getInt(1);    
		this.calculate_in_date 		= rs.getDate(2);
		this.calculate_in_id 		= rs.getString(3);
		this.calculate_out_date 	= rs.getDate(4);
		this.calculate_out_id 		= rs.getString(5);
		this.calculate_close 		= rs.getString(6);
		this.calculate_total_price 	= rs.getInt(7);
	}

	public Integer getCalculate_idx() {
		return calculate_idx;
	}

	public Date getCalculate_in_date() {
		return calculate_in_date;
	}

	public String getCalculate_in_id() {
		return calculate_in_id;
	}

	public Date getCalculate_out_date() {
		return calculate_out_date;
	}

	public String getCalculate_out_id() {
		return calculate_out_id;
	}

	public String getCalculate_close() {
		return calculate_close;
	}

	public Integer getCalculate_total_price() {
		return calculate_total_price;
	}
	
	public int getOpenDay() {
		return calculate_in_date.getDay();
	}

}

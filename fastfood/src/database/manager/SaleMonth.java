package database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMonth {
	private Integer iMonth;
	private Long	lPrice;
	private Integer iX;
	private Integer iY;
	
	public SaleMonth(ResultSet rs) throws SQLException {
		this.iMonth = rs.getInt(1);
		this.lPrice = rs.getLong(2);
	}
	
	public SaleMonth(int iMonth, long lPrice) {
		this.iMonth = iMonth;
		this.lPrice = lPrice;
	}

	public Integer getiMonth() {
		return iMonth;
	}

	public Long getlPrice() {
		return lPrice;
	}
	
	public Integer getiX() {
		return iX;
	}
	
	public Integer getiY() {
		return iY;
	}
	
	public void setiX(Integer iX) {
		this.iX = iX;
	}
	
	public void setiY(Integer iY) {
		this.iY = iY;
	}
	
	@Override
	public String toString() {
		return String.format("%d : %d", iMonth, lPrice);
	}
	
}

package database.manager;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleMonth {
	private Integer iMonth;
	private Long	lPrice;
	
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
	
	@Override
	public String toString() {
		return String.format("%d : %d", iMonth, lPrice);
	}
	
}

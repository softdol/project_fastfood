package kioske.YounukLee7.dbtablePocket;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment_List {

	private Integer payment_idx;
	private String payment_type;
	private String payment_cash_receipts;
	private Integer payment_price;
	private String payment_date;
	
	public Payment_List(ResultSet rs) throws SQLException {
		payment_idx = rs.getInt("payment_idx");
		payment_type = rs.getString("payment_type");
		payment_cash_receipts = rs.getString("payment_cash_receipts");
		payment_price = rs.getInt("payment_price");
		payment_date = rs.getString("payment_date");
	}

	public Integer getPayment_idx() {
		return payment_idx;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public String getPayment_cash_receipts() {
		return payment_cash_receipts;
	}

	public Integer getPayment_price() {
		return payment_price;
	}

	public String getPayment_date() {
		return payment_date;
	}
	
	
}

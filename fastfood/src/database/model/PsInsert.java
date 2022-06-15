package database.model;

public class PsInsert {
	private char type;
	private String val;
	
	public PsInsert(char type, String val) {
		this.type = type;
		this.val = val;				
	}
	
	public char getType() {
		return type;
	}
	
	public String getVal() {
		return val;
	}
}

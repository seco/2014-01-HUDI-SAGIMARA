package database;

public class TableVERIFICATION implements Table {
	private String verification_id;
	private String verification_time;
	
	public String getVerification_id() {
		return verification_id;
	}
	public void setVerification_id(String verification_id) {
		this.verification_id = verification_id;
	}
	public String getVerification_time() {
		return verification_time;
	}
	public void setVerification_time(String verification_time) {
		this.verification_time = verification_time;
	}
	@Override
	public Table getter() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setter(Table table) {
		// TODO Auto-generated method stub
		
	}
}
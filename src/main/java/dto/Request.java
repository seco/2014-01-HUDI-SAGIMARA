package dto;

public class Request extends BaseModel{
	private String requestFrom;
	private String requestTo;
	private String requestDate;
	
	public Request(String requestFrom, String requestTo, String requestDate) {
		super();
		this.requestFrom = requestFrom;
		this.requestTo = requestTo;
		this.requestDate = requestDate;
	}
	public Request() {
		// TODO Auto-generated constructor stub
	}
	public String getRequestFrom() {
		return requestFrom;
	}
	public void setRequestFrom(String requestFrom) {
		this.requestFrom = requestFrom;
	}
	public String getRequestTo() {
		return requestTo;
	}
	public void setRequestTo(String requestTo) {
		this.requestTo = requestTo;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
}

package model;

public class UserDetail {
	private int UDId ;
	private String fullname ; 
	private int userId ;
	
	public UserDetail() {
	}

	public UserDetail(int uDId, String fullname, int userId) {
		UDId = uDId;
		this.fullname = fullname;
		this.userId = userId;
	}

	public int getUDId() {
		return UDId;
	}

	public void setUDId(int uDId) {
		UDId = uDId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetail [UDId=" + UDId + ", fullname=" + fullname + ", userId=" + userId + "]";
	}
	
	
}

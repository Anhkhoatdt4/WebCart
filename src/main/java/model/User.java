package model;

public class User {
	private int userid;
	private String username;
	private String password;
	private String address;
	private String uPhone;
	private int role;
	
	public User() {
		
	}

	public User(int userid, String username, String password, String address, String uPhone, int role) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.address = address;
		this.uPhone = uPhone;
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", uPhone=" + uPhone + ", role=" + role + "]";
	}

	

	
	
	
	
}

package model;

public class UserEmail {
	private String email ;
	private int Email_Id ; 
	
	public UserEmail() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(int email_Id) {
		Email_Id = email_Id;
	}

	@Override
	public String toString() {
		return "UserEmail [email=" + email + ", Email_Id=" + Email_Id + "]";
	}
	
	
}

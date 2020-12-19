package vo;

import java.io.Serializable;

public class User implements Serializable {
	
	private String chrName;
	private String role;
	private String userName;
	private String password;

	public User(String chrName, String role, String userName, String password) {
		super();
		this.chrName = chrName;
		this.role = role;
		this.userName = userName;
		this.password = password;
	}
	
	public User() {
		
	}


	@Override
	public String toString() {
		return "User [chrName=" + chrName + ", role=" + role + ", userName=" + userName + ", password=" + password
				+ ", getChrName()=" + getChrName() + ", getRole()=" + getRole() + ", getUserName()=" + getUserName()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}



	public String getChrName() {
		return chrName;
	}



	public void setChrName(String chrName) {
		this.chrName = chrName;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

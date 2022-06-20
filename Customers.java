package servlet;

public class Customers {
	
	private String username;
	private String password;
	private String email;
	private String country;
	private long ph_num;
	Customers(String username, String password, String email, String country, long ph_num){
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.ph_num = ph_num;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPh_num() {
		return ph_num;
	}
	public void setPh_num(long ph_num) {
		this.ph_num = ph_num;
	}
}

package testAddstudent;

public class TestcaseAddstudent {
	private	String name;
	private String ing;
	private String password;
	private String phone;
	private String email;
	private String role;
	private String message;
	
	
	
	public TestcaseAddstudent(String name, String ing, String password, String phone, String email,String role,String message) {
		super();
		this.name = name;
		this.ing = ing;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.role = role;
		this.message= message;
	}
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIng() {
		return ing;
	}
	public void setIng(String ing) {
		this.ing = ing;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}

package loginn;

public class TestcaseLogin {
	private String user;
	private String password;
	private String message;
	
	
	public TestcaseLogin(String user, String password,String message) {
		this.user = user;
		this.password = password;
		this.message = message;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

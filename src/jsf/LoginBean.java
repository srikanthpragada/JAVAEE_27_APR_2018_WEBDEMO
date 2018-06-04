package jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	private String username, password, message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Action Controller
	public String login() {
		if (username.equals("admin") && password.equals("admin"))
			return "home"; // home.xhtml
		else {
			message = "Invalid Login. Try Again!";
			return "login"; // login.xhtml
		}
	}

}

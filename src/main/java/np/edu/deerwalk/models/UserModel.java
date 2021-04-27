package np.edu.deerwalk.models;

import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class UserModel {
	@Id
	private String id;
	private String fname;
	private String username;
	private String email;
	private String password;
	private String[] logs = {};
	
	public UserModel() {
		
	}
	
	public UserModel(String id, String fname, String username, String email, String password) {
		this.id = id;
		this.setFname(fname);
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String[] getLogs() {
		return logs;
	}

	public void setLogs(String[] logs) {
		this.logs = logs;
	}
	
	public void appendLog(String log) {
		this.logs = Arrays.copyOf(this.logs, this.logs.length + 1);
		this.logs[this.logs.length - 1] = log;
	}
	

}

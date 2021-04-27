package np.edu.deerwalk.models;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class LogModel {
	@Id
	private String id;
	private String name;
	private String[][] logs;
	
	public LogModel() {
	}
	
	public LogModel(String id, String name, String[][] logs) {
		this.id = id;
		this.name = name;
		this.logs = logs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String[][] getLogs() {
		return logs;
	}

	public void setLogs(String[][] logs) {
		this.logs = logs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void appendLog(String[] log) {
		this.logs = Arrays.copyOf(this.logs, this.logs.length + 1);
		this.logs[this.logs.length - 1] = log;
	}
	

}

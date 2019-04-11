package com.taiji.yuhongyue.domain;

public class Users {
	
	private String username;
	private String password;
	private boolean enable;
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
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", enable=" + enable + "]";
	}
	
	
	
	   
}

package com.nt.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{
private String username,pwd;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}
}

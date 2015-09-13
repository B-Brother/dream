package com.sven.dream.common.query;

/**
 * 用户查询对象
 * 
 * @author beckham
 * 
 */
public class UserQuery {
	private String loginName;
	
	private String password;

	private String nick;
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}

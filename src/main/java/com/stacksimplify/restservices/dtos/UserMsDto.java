package com.stacksimplify.restservices.dtos;

public class UserMsDto {
	private Long userid;
	private String username;
	private String emailAddress;
	private String rolename;
	public UserMsDto() {
	}
	
	public UserMsDto(Long userid, String username, String emailAddress, String rolename) {
		super();
		this.userid = userid;
		this.username = username;
		this.emailAddress = emailAddress;
		this.rolename = rolename;
	}

	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	

}

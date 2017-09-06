package com.mycompany.groupMsg.dto;

import java.util.Date;

public class TaskDto {

	private String serial;
	private String groupSerial;
	private String memberSerial;
	private String name;
	private Date regDate;
	private Date expiredDate;
	private String todo;
	private String isCompleted;
	
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getGroupSerial() {
		return groupSerial;
	}
	public void setGroupSerial(String groupSerial) {
		this.groupSerial = groupSerial;
	}
	public String getMemberSerial() {
		return memberSerial;
	}
	public void setMemberSerial(String memberSerial) {
		this.memberSerial = memberSerial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(String isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
}

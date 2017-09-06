package com.mycompany.groupMsg.dto;

import java.util.Date;

public class GroupMemberDto {

	private String serial;
	private String groupSerial;
	private String memberSerial;
	private String id;
	private Date regDate;
	private boolean isMaster;
	
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean getIsMaster() {
		return isMaster;
	}
	public void setIsMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}



	
	
}

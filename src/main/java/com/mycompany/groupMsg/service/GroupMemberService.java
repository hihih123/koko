package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import com.mycompany.groupMsg.dto.GroupMemberDto;

public interface GroupMemberService {

	public boolean addGroupMember(String groupSerial, String memberSerial, String id, boolean isMaster);
	public ArrayList<GroupMemberDto> getGroupMember(String groupSerial);
	public ArrayList<GroupMemberDto> getGroupMember2(String groupSerial, String id);
	public void delGroupMember(String groupMemberSerial);
}

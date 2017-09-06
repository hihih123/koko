package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import com.mycompany.groupMsg.dto.GroupDto;

public interface GroupService {
	
	public ArrayList<GroupDto> getGroup(String memberSerial);
	public GroupDto getGroup2(String groupSerial);
	public String addGroup(GroupDto groupDto, String memberSerial);
	public void updateGroup(String groupSerial, int sumInvMember);
}

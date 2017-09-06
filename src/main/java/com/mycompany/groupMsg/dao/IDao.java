package com.mycompany.groupMsg.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mycompany.groupMsg.dto.GroupDto;
import com.mycompany.groupMsg.dto.GroupMemberDto;
import com.mycompany.groupMsg.dto.MemberDto;
import com.mycompany.groupMsg.dto.TaskDto;

@Repository
public interface IDao {

	//회원
	public ArrayList<MemberDto> getMemberDao(String id);
	public ArrayList<MemberDto> getMemberDao2(String id, String pw);
	public void addMemberDao(String id, String pw, String firstName, String lastName);
	
	//그룹
	public ArrayList<GroupDto> getGroupDao(String memberSerial);
	public ArrayList<GroupDto> getGroupDao2(String memberSerial, String name);
	public GroupDto getGroupDao3(String groupSerial);
	public void addGroupDao(GroupDto groupDto);
	public void updateGroupDao(String groupSerial, int sumInvMember);
	
	//할일
	public ArrayList<TaskDto> getTaskDao(String groupSerial);
	public ArrayList<TaskDto> getTaskDoneDao(String groupSerial);
	public void addTaskDao(String groupSerial, String memberSerial, String name, String todo);
	public void updateTaskDao(String taskSerial, String memberSerial);
	
	//그룹멤버
	public void addGroupMemberDao(String groupSerial, String memberSerial, String id, boolean isMaster);
	public void delGroupMemberDao(String groupMemberSerial);
	public ArrayList<GroupMemberDto> getGroupMemberDao(String groupSerial);
	public ArrayList<GroupMemberDto> getGroupMemberDao2(String groupSerial, String id);
}

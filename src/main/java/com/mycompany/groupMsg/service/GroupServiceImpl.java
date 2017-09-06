package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.mycompany.groupMsg.dao.IDao;
import com.mycompany.groupMsg.dto.GroupDto;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Autowired
	private DataSourceTransactionManager transManager;
	
	private SqlSession sqlSession;
	private IDao dao;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession = sqlSession;
		dao = sqlSession.getMapper(IDao.class);
	}
	
	@Override
	public ArrayList<GroupDto> getGroup(String memberSerial) {
		
		ArrayList<GroupDto> dtos = null;
		
		try{
			dtos = dao.getGroupDao(memberSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	@Override
	public GroupDto getGroup2(String groupSerial) {

		GroupDto dto = null;
		
		try{
			dto = dao.getGroupDao3(groupSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public String addGroup(GroupDto groupDto, String memberSerial) {

		groupDto.setMemberSerial(memberSerial);
		String name = groupDto.getName();
		
        try{
			
        	ArrayList<GroupDto> dtos = dao.getGroupDao2(memberSerial, name);
        	
        	if(dtos.size() > 0) return null; //동일 그룹 이름 존재
        	
        	dao.addGroupDao(groupDto);//dto에 증가된 키값을 주입 받는다.
        				
        }catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
        
        return groupDto.getSerial();//방금 insert된 그룹 serial 반환
	}

	@Override
	public void updateGroup(String groupSerial, int sumInvMember) {

		try{
			dao.updateGroupDao(groupSerial, sumInvMember);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}



}

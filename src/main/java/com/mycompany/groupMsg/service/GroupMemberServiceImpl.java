package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.mycompany.groupMsg.dao.IDao;
import com.mycompany.groupMsg.dto.GroupMemberDto;

@Service("groupMemberService")
public class GroupMemberServiceImpl implements GroupMemberService {

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
	public ArrayList<GroupMemberDto> getGroupMember(String groupSerial) {

		try{
			
			return dao.getGroupMemberDao(groupSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return null;
	}
	
	@Override
	public ArrayList<GroupMemberDto> getGroupMember2(String groupSerial, String id) {
		
		try{
			
			return dao.getGroupMemberDao2(groupSerial,id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public boolean addGroupMember(String groupSerial, String memberSerial, String id, boolean isMaster) {
		
		try{
			
			ArrayList<GroupMemberDto> dtos = dao.getGroupMemberDao2(groupSerial, id);
			if(dtos.size() > 0) return false;
			
			dao.addGroupMemberDao(groupSerial, memberSerial, id, isMaster);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void delGroupMember(String groupMemberSerial) {

		try{
			
			dao.delGroupMemberDao(groupMemberSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	
}

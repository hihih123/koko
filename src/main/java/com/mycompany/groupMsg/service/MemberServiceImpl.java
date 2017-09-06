package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.mycompany.groupMsg.dao.IDao;
import com.mycompany.groupMsg.dto.MemberDto;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

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
	public boolean existMember(MemberDto memberDto, HttpSession session){
		
		String id = memberDto.getId();
		String pw = memberDto.getPw();

        try{
			ArrayList<MemberDto> members = dao.getMemberDao2(id,pw);
			
			if(members.size() == 0) return false; //계정 없음

			session.setAttribute("serial", members.get(0).getSerial());
			session.setAttribute("id", members.get(0).getId());
			session.setAttribute("firstName", members.get(0).getFirstName());
			
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
        return true;
	}
	
	@Override
	public ArrayList<MemberDto> getMember(String id){
		
        try{
			return dao.getMemberDao(id);
			
        }catch(Exception e){
        	e.printStackTrace();
        }
        return null;
	}
	
	@Override
	public boolean addMember(MemberDto memberDto){
		
		String id = memberDto.getId();
		String pw = memberDto.getPw();
		String firstName = memberDto.getFirstName();
		String lastName = memberDto.getLastName();
		
        try{
			
        	ArrayList<MemberDto> member = dao.getMemberDao(id);
        	
        	if(member.size() > 0) return false; //동일 아이디 존재
        	
        	dao.addMemberDao(id,pw,firstName,lastName);
						
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
        return true;
	}
	
}

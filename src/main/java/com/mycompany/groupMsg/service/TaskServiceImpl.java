package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.mycompany.groupMsg.dao.IDao;
import com.mycompany.groupMsg.dto.TaskDto;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

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
	public ArrayList<TaskDto> getTask(String groupSerial) {

		ArrayList<TaskDto> dtos = null;
		
		try{
			dtos = dao.getTaskDao(groupSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dtos;
	}

	@Override
	public void addTask(String memberSerial, String groupSerial, String todo, String name) {

		try{
			dao.addTaskDao(groupSerial, memberSerial, name, todo);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateTask(String memberSerial, String taskSerial) {
		
		try{
			dao.updateTaskDao(taskSerial, memberSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<TaskDto> getTaskDone(String groupSerial) {
		
		ArrayList<TaskDto> dtos = null;
		
		try{
			dtos = dao.getTaskDoneDao(groupSerial);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return dtos;
	}
	
	

}

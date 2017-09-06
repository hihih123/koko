package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import com.mycompany.groupMsg.dto.TaskDto;

public interface TaskService {
	
	public ArrayList<TaskDto> getTask(String groupSerial);
	public ArrayList<TaskDto> getTaskDone(String groupSerial);
	public void addTask(String memberSerial, String groupSerial, String todo, String name);
	public void updateTask(String memberSerial, String taskSerial);
	
}

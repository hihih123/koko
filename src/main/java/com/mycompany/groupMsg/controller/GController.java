package com.mycompany.groupMsg.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.groupMsg.dto.GroupDto;
import com.mycompany.groupMsg.dto.GroupMemberDto;
import com.mycompany.groupMsg.dto.MemberDto;
import com.mycompany.groupMsg.dto.TaskDto;
import com.mycompany.groupMsg.service.GroupMemberService;
import com.mycompany.groupMsg.service.GroupService;
import com.mycompany.groupMsg.service.MemberService;
import com.mycompany.groupMsg.service.TaskService;

@Controller
public class GController {
	
	private static final Logger logger = LoggerFactory.getLogger(GController.class);

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private GroupMemberService groupMemberService;
	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Model model) {
		logger.info("Welcome to index");
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, MemberDto memberDto) {
		
		Boolean result = memberService.existMember(memberDto, request.getSession());
		
		if(result) return "redirect:group";
		else return "redirect:index"; 
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:index"; 
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/joinAdd")
	public String joinAdd(MemberDto memberDto) {
		
		boolean result = memberService.addMember(memberDto);
		
		if(result) return "redirect:index";
		else return "redirect:join?r=fail";
	}
	
	@RequestMapping(value = "/group")
	public String group(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String memberSerial = (String)session.getAttribute("serial");
		
		ArrayList<GroupDto> groupDtos = groupService.getGroup(memberSerial);
		
		model.addAttribute("dtos", groupDtos);
		
		return "group";
	}
	
	@RequestMapping(value = "/groupMake")
	public String groupMake() {
		
		return "groupMake";
	}
	
	@RequestMapping(value = "/groupAdd")
	public String groupAdd(HttpServletRequest request, GroupDto groupDto) {
		
		HttpSession session = request.getSession();
		String memberSerial = (String)session.getAttribute("serial");
		String id = (String)session.getAttribute("id");
		
		String groupSerial = groupService.addGroup(groupDto, memberSerial);
		
		if(groupSerial != null){ 
			groupMemberService.addGroupMember(groupSerial, memberSerial, id, true);
			groupService.updateGroup(groupSerial, +1);
			return "redirect:group";
		}
		else return "redirect:groupMake?r=fail";
	}
	
	@RequestMapping(value = "/task")
	public String task(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String memberSerial = (String)session.getAttribute("serial");
		String id = (String)session.getAttribute("id");
	    String groupSerial = request.getParameter("gid");
		
		ArrayList<TaskDto> dtos = taskService.getTask(groupSerial);
		
		ArrayList<GroupMemberDto> groupMemberDtos = groupMemberService.getGroupMember2(groupSerial, id);
		
		boolean isGroupMaker = groupMemberDtos.get(0).getIsMaster();
		
		GroupDto groupDto = groupService.getGroup2(groupSerial);
		
		model.addAttribute("groupName", groupDto.getName());
		model.addAttribute("userSerial", memberSerial);
		model.addAttribute("isGroupMaker", isGroupMaker);
		model.addAttribute("dtos", dtos);
		
		return "task";
	}
	
	@RequestMapping(value = "/taskAdd")
	public String taskAdd(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberSerial = (String)session.getAttribute("serial");
		String name = (String)session.getAttribute("firstName");
		String groupSerial = request.getParameter("gid");
		String todo = request.getParameter("todo");
		
		taskService.addTask(memberSerial, groupSerial, todo, name);
		
		return "redirect:task?gid=" + groupSerial;
	}
	
	@RequestMapping(value = "/taskOk")
	public String taskOk(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String memberSerial = (String)session.getAttribute("serial");
		String groupSerial = request.getParameter("gid");
		String taskSerial = request.getParameter("tid");
		
		taskService.updateTask(memberSerial, taskSerial);
		
		return "redirect:task?gid=" + groupSerial;
	}
	
	@RequestMapping(value = "/taskDone")
	public String taskDone(HttpServletRequest request, Model model) {
		
	    String groupSerial = request.getParameter("gid");
		
		ArrayList<TaskDto> dtos = taskService.getTaskDone(groupSerial);
		GroupDto groupDto = groupService.getGroup2(groupSerial);
		
		model.addAttribute("groupName", groupDto.getName());
		model.addAttribute("dtos", dtos);
		
		return "taskDone";
	}
	
	@RequestMapping(value = "/invitation")
	public String invitation(HttpServletRequest request, Model model) {
		
	    String groupSerial = request.getParameter("gid");
		
		ArrayList<GroupMemberDto> dtos = groupMemberService.getGroupMember(groupSerial);
		GroupDto groupDto = groupService.getGroup2(groupSerial);
		
		model.addAttribute("groupName", groupDto.getName());
		model.addAttribute("dtos", dtos);
		
		return "invitation";
	}
	
	@RequestMapping(value = "/invitationMake")
	public String invitationMake(HttpServletRequest request, Model model) {
		
	    String groupSerial = request.getParameter("gid");
		
		ArrayList<GroupMemberDto> dtos = groupMemberService.getGroupMember(groupSerial);
		GroupDto groupDto = groupService.getGroup2(groupSerial);
		
		model.addAttribute("groupName", groupDto.getName());
		model.addAttribute("dtos", dtos);
		
		return "invitationMake";
	}
	
	@RequestMapping(value = "/invAdd")
	public String invAdd(HttpServletRequest request) {
		
		String groupSerial = request.getParameter("gid");
		String id = request.getParameter("id");
		
	  	ArrayList<MemberDto> dtos = memberService.getMember(id);
		
	  	if(dtos == null || dtos.size() == 0){
	  		return "redirect:invitationMake?r=fail&gid=" + groupSerial;
	  	}else{
	  		
	  		String tMemberSerial = dtos.get(0).getSerial();
	  		String tId = dtos.get(0).getId();
	  		boolean result;
	  		result = groupMemberService.addGroupMember(groupSerial, tMemberSerial, tId, false);//그룹원 추가
	  		
	  		if(result == false){
	  			return "redirect:invitationMake?r=same&gid=" + groupSerial;
	  		}
	  		
	  		groupService.updateGroup(groupSerial, +1);//그룹에 참여 인원 1 증가
	  		return "redirect:invitationMake?gid=" + groupSerial;
	  	}
	}
	
	@RequestMapping(value = "/invSub")
	public String invSub(HttpServletRequest request, Model model) {
		
	    String groupSerial = request.getParameter("gid");
	    String groupMemberSerial = request.getParameter("sid");
		
	    groupMemberService.delGroupMember(groupMemberSerial);
	    groupService.updateGroup(groupSerial, -1);//그룹에 참여 인원 1 감소
	    
		return "redirect:invitationMake?gid=" + groupSerial;
	}
	
	@RequestMapping(value = "/term")
	public String term(Locale locale, Model model) {
		
		return "term";
	}
	
}

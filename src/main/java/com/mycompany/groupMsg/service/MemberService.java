package com.mycompany.groupMsg.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mycompany.groupMsg.dto.MemberDto;

public interface MemberService {

	public boolean existMember(MemberDto memberDto, HttpSession session);
	public boolean addMember(MemberDto memberDto);
	public ArrayList<MemberDto> getMember(String id);
}

package com.mycompany.groupMsg.interceptor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor {

	ArrayList<String> excludedUris = new ArrayList<String>();
	
	public UserInterceptor()
	{
		// 로그인 검사 제외 주소
		//excludedUris.add("/resources"); // servlet-context.xml에 resource 경로는 인터셉터 이벤트가 발생하지 않는다.
		excludedUris.add("/index");
		excludedUris.add("/term");//가입약관
		excludedUris.add("/join");
		excludedUris.add("/joinAdd");
		excludedUris.add("/login");
		excludedUris.add("/logout");
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		for (String excludedUri : excludedUris) {
			if (request.getRequestURI().startsWith(request.getContextPath() + excludedUri)) {
				// System.out.println("로그인 검사 제외 페이지 = " + request.getContextPath() + excludedUri + " == " + request.getRequestURI());
				return true;
			}
		}

		if (request.getSession().getAttribute("id") != null) { // 로그인 체크
			// System.out.println("로그인 인증!!!");
			return true;

		} else {
			// System.out.println("로그인 미인증!"); // 로그인 미인증
			response.sendRedirect(request.getContextPath() + "/index"); // 해당 페이지로 보내기
			return false;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

}

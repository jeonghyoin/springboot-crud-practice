package com.example.demo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.board.service.CustomUserDetailsService;
import com.example.demo.board.vo.Member;

@Controller
public class UserController {
	@Autowired CustomUserDetailsService customUserDetailsService;
	
	@RequestMapping(value="/login")
    public String RedirectToLoginForm() {
		return "/user/loginForm";
    }
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	}
	
	@RequestMapping(value="/joinForm")
    public String RedirectToJoinForm() {
		return "/user/joinForm";
    }
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String insertMember(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		Member member = new Member();
		member.setUsername(username);
    	member.setAccountNonExpired(true);
    	member.setAccountNonLocked(true);
    	member.setCredentialsNonExpired(true);
    	member.setEnabled(true);
    	member.setLoginFailCnt(0);
		
		customUserDetailsService.saveUser(member, password, "ROLE_"+role);
		
		return "/user/login";
	}
	
	/* 구현 미완 */
	@RequestMapping(value="/join/authAdmin", method=RequestMethod.GET)
	public String authAdmin() {
		return "/user/authAdmin";
	}
}
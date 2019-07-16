package com.example.demo.board.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.board.service.CustomUserDetailsService;

@Component("authenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	@Autowired CustomUserDetailsService customUserDetailsService;
	
	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication)
    		throws IOException, ServletException {
		setDefaultTargetUrl("/list");
		
		//String username = request.getParameter("username");
		//isNotEnable(username);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	protected void isNotEnable(String username) {
		//LockedException
		boolean enableVaule = customUserDetailsService.isUserEnable(username);
		System.out.println(enableVaule);
		
		if(enableVaule)
			setDefaultTargetUrl("/list");
		else
			setDefaultTargetUrl("/login?error");
    }
}
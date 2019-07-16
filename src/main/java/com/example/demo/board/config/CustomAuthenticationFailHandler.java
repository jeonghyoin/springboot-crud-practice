package com.example.demo.board.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.board.service.CustomUserDetailsService;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired CustomUserDetailsService customUserDetailsService;
	
	@Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception)
    		throws IOException, ServletException {

		setDefaultFailureUrl("/login?error");
		
        String username = request.getParameter("username");
        loginFailure(username);
        
		super.onAuthenticationFailure(request, response, exception);
	}

	protected void loginFailure(String username) {
		customUserDetailsService.failureCount(username);
        int lockCount = customUserDetailsService.checkFailureCount(username);
        
        if(lockCount >= 5) {
        	customUserDetailsService.lockThisUser(username);
        }
    }
}
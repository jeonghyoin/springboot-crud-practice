package com.example.demo.security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.board.service.CustomUserDetailsService;

@Service
public class CustomAuthProvider implements AuthenticationProvider {
	@Autowired CustomUserDetailsService customUserDetailsService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String username  = auth.getPrincipal().toString();
		String password = auth.getCredentials().toString();
		UserDetails validUser = customUserDetailsService.loadUserByUsername(username);
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
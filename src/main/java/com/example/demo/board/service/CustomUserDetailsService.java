package com.example.demo.board.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.UserMapper;
import com.example.demo.board.vo.Member;

//authService
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userMapper.readUser(username);
        member.setAuthorities(getAuthorities(username));
        
        if(member != null) {
            member.setAuthorities(makeGrantedAuthority(userMapper.readAuthority(username)));
        }
        return member;
    }
    
    public void saveUser(Member member, String password, String role) {
    	
    	String rowPassword = password;
    	String endcodePassword = new BCryptPasswordEncoder().encode(rowPassword);
    	member.setPassword(endcodePassword);

    	userMapper.insertUser(member);
    	userMapper.insertAutority(member.getUsername(), role);
	}
    
    private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(role)));
        return list;
    }
    private List<GrantedAuthority> getAuthorities(String username){
        List<String> authorityList = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(String authority : authorityList) {
        	authorities.add(new SimpleGrantedAuthority(authority));
        }
        
        return authorities;
    }

	public void failureCount(String username) {
		userMapper.failureCount(username);
	}
	public int checkFailureCount(String username) {
		return userMapper.checkFailureCount(username);
	}
	
	public void lockThisUser(String username) {
		userMapper.lockThisUser(username);
	}
	public boolean isUserEnable(String username) {
		return userMapper.isUserEnable(username);
	} 
}
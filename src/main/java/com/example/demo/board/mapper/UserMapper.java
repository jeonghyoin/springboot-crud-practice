package com.example.demo.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.vo.Member;

@Mapper
public interface UserMapper {
	//security
    public Member readUser(String username);
    public List<String> readAuthority(String username);
	
	public void insertUser(Member member);
	public void insertAutority(String username, String autority);
	public Member readAllUsers();
	
	public void failureCount(String username);
	public int checkFailureCount(String username);
	public void lockThisUser(String username);
	public boolean isUserEnable(String username);
	
	//progressbar
	public void updateProgress(Map<String, Object> parameters);
	
	public List<Member> showUserList();
}
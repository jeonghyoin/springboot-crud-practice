package com.example.demo.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.UserMapper;
import com.example.demo.board.vo.Member;


@Service
public class AdminService {
	
	@Autowired UserMapper userMapper;

	public void updateProgress(Map<String, Object> parameters) {
		userMapper.updateProgress(parameters);
	}

	public List<Member> showUserList() {
		return userMapper.showUserList();
	}
}

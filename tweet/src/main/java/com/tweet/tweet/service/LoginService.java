package com.tweet.tweet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.tweet.dto.RegisterDTO;
import com.tweet.tweet.entity.RegisterEntity;
import com.tweet.tweet.mapper.RegisterMapper;
import com.tweet.tweet.repository.LoginRepo;

@Service
public class LoginService {

	LoginRepo loginRepo;
	@Autowired
	RegisterMapper mapper;

	@Autowired
	public void setLoginRepo(LoginRepo loginRepo) {
		this.loginRepo = loginRepo;
	}
	
	
	public RegisterDTO userLogin(String loginId , String password) {
		RegisterEntity entity = loginRepo.login(loginId, password);
		return mapper.entityToDto(entity);
	}
	
	
}

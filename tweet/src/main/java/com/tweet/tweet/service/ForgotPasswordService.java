package com.tweet.tweet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.tweet.entity.RegisterEntity;
import com.tweet.tweet.repository.RegisterRepo;

@Service
public class ForgotPasswordService {

	RegisterRepo registerRepo;

	@Autowired
	public ForgotPasswordService(RegisterRepo registerRepo) {
		this.registerRepo = registerRepo;
	}
	
	public String changePassword(String loginId , String email , String newpassword) {
		
		RegisterEntity entity = registerRepo.findUser(loginId , email);
		if(entity != null) {
		entity.setcPassword(newpassword);
		entity.setPassword(newpassword);
		registerRepo.save(entity);
		return "Password chanegs ";
		}
		
		return "Account not exitxs";
	}
	
}

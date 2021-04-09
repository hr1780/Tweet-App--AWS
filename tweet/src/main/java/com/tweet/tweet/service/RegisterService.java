package com.tweet.tweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tweet.tweet.dto.RegisterDTO;
import com.tweet.tweet.entity.RegisterEntity;
import com.tweet.tweet.mapper.RegisterMapper;
import com.tweet.tweet.repository.RegisterRepo;

@Service
public class RegisterService {

	RegisterRepo registerRepo ;
	RegisterMapper mapper;

	@Autowired
	public RegisterService(RegisterRepo registerRepo) {
		this.registerRepo = registerRepo;
	}
	
	@Autowired
	public void setMapper(RegisterMapper mapper) {
		this.mapper = mapper;
	}
	
	
	public RegisterDTO registerUser(RegisterEntity registerEntity) {
		return mapper.entityToDto(registerRepo.save(registerEntity));
		
	}

	@Transactional
	public List<RegisterDTO> viewUser() {
		List<RegisterEntity> entity = registerRepo.findAll();	
		System.out.println(entity);
		return mapper.entityToDto(entity);
	}
	
}

package com.tweet.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.tweet.dto.RegisterDTO;
import com.tweet.tweet.entity.RegisterEntity;
import com.tweet.tweet.service.RegisterService;

@RestController
public class RegisterController {

	RegisterService registerService;

	@Autowired
	public void setRegistrationService(RegisterService registerService) {
		this.registerService = registerService;
	}

	
	  @PostMapping("/register") 
	  public ResponseEntity<RegisterDTO>registerUser(@RequestBody RegisterEntity registerEntity){ return new
	  ResponseEntity<>(registerService.registerUser(registerEntity), HttpStatus.OK); }
	 

	@GetMapping(value = "/view", produces = "application/json")
	public ResponseEntity<List<RegisterDTO>> viewUser() {
		return new ResponseEntity<>(registerService.viewUser(), HttpStatus.OK);
	}
}

package com.tweet.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.tweet.dto.RegisterDTO;
import com.tweet.tweet.service.LoginService;

@RestController
public class LoginController {

	LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@GetMapping(value = "/login" ,produces = "application/json")
	public ResponseEntity<RegisterDTO> userLogin(@RequestParam String loginId , @RequestParam String password){
		return new ResponseEntity<RegisterDTO>(loginService.userLogin(loginId, password), HttpStatus.ACCEPTED);
		
	}
	
}

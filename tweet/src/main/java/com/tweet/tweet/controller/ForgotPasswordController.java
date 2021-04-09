package com.tweet.tweet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.tweet.service.ForgotPasswordService;

@RestController
public class ForgotPasswordController {

	ForgotPasswordService passwordService;
	
	@Autowired
	public ForgotPasswordController(ForgotPasswordService passwordService) {
		this.passwordService = passwordService;
	}
	
	@GetMapping("/{loginId}/forgot")
	public ResponseEntity<String> changePassword(@PathVariable String loginId, @RequestParam String email, @RequestParam String newPassword){
		return new ResponseEntity<String>(passwordService.changePassword(loginId, email, newPassword), HttpStatus.OK);
	}
}

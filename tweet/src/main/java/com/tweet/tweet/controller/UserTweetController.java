package com.tweet.tweet.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.tweet.dto.UserTweetDTO;
import com.tweet.tweet.service.UserTweetService;

@RestController
public class UserTweetController {

	UserTweetService service;

	@Autowired
	public UserTweetController(UserTweetService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/{loginId}/add")
	public ResponseEntity<String> postTweet(@PathVariable String loginId , @RequestBody String tweet) {
		return new ResponseEntity<String> (service.postTweet(loginId , tweet), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/all" ,  produces = "application/json")
	public ResponseEntity<List<UserTweetDTO>> getAllTweet(){
		return new ResponseEntity<List<UserTweetDTO>>(service.getAllTweet(), HttpStatus.OK);
	}
	
	
}

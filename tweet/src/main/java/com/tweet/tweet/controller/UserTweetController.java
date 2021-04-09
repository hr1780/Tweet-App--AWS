package com.tweet.tweet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.tweet.service.UserTweetService;

@RestController
public class UserTweetController {

	UserTweetService service;

	@Autowired
	public UserTweetController(UserTweetService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/{loginId}/add")
	public String postTweet(@PathVariable String loginId , @RequestBody String tweet) {
		return service.postTweet(loginId , tweet);
	}
}

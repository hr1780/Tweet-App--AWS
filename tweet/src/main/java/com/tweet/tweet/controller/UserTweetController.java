package com.tweet.tweet.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.tweet.dto.RegisterDTO;
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
	
	@GetMapping(value = "/users/all")
	public ResponseEntity<List<String>> getAllUsers(){
		return new ResponseEntity<List<String>>(service.getAllUsers(), HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/{loginId}/all")
	public ResponseEntity<List<String>> getUserTweet(@PathVariable String loginId){
		return new ResponseEntity<List<String>>(service.getUserTweet(loginId), HttpStatus.FOUND);
	}
	
	@DeleteMapping(value = "/{loginId}/delete/{tweetId}")
	public ResponseEntity<String> deleteTweet(@PathVariable String loginId , @PathVariable int tweetId ){
		return new ResponseEntity<String>(service.deleteTweet(loginId , tweetId), HttpStatus.GONE);
	}
	
	@PutMapping(value = "/{loginId}/update/{tweetId}")
	public ResponseEntity<UserTweetDTO> changeTweet(@RequestBody String tweet, @PathVariable String loginId , @PathVariable int tweetId){
		return new ResponseEntity<UserTweetDTO>(service.changeTweet(tweet, tweetId, loginId), HttpStatus.OK);
	}
	
	@GetMapping("/user/search/{username}")
	public ResponseEntity<List<RegisterDTO>> findUser(@PathVariable String username){
		return new ResponseEntity<List<RegisterDTO>>(service.searchUser(username), HttpStatus.FOUND);
		
	}
}

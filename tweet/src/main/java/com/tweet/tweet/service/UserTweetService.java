
package com.tweet.tweet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweet.tweet.entity.UserTweetEntity;
import com.tweet.tweet.mapper.UserTweetMapper;
import com.tweet.tweet.repository.UserTweetRepo;

@Service
public class UserTweetService {

	UserTweetRepo repo;
	UserTweetMapper mapper;
	
	@Autowired
	public void setRepo(UserTweetRepo repo) {
		this.repo = repo;
	}
	@Autowired
	public void setMapper(UserTweetMapper mapper) {
		this.mapper = mapper;
	}
	
	public String postTweet(String loginId , String tweet) {
		UserTweetEntity entity = new UserTweetEntity();
		entity.setTweet(tweet);
		entity.setLoginid(loginId);
		UserTweetEntity entity2 = repo.save(entity);
		System.out.println(entity2);
		return entity2.getTweet();
		
	}
	
}

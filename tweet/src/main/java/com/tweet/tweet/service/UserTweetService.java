
package com.tweet.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.tweet.dto.UserTweetDTO;
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
		entity.setTweetId(SequenceGeneratorService.generateSequence(UserTweetEntity.SEQUENCE_NAME));
		entity.setTweet(tweet);	
		entity.setLoginId(loginId);
		UserTweetEntity entity2 = repo.save(entity);
		return entity2.getTweet();
		
	}
	
	public List<UserTweetDTO> getAllTweet() {
		return mapper.entityToDto(repo.findAll());
	}
	
	public List<String> getUserTweet(String loginId){
		List<String> list = repo.findAllByUser(loginId);
		return list;
	}
}

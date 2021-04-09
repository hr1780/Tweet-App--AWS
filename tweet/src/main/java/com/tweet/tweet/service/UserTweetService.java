
package com.tweet.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.tweet.tweet.dto.RegisterDTO;
import com.tweet.tweet.dto.UserTweetDTO;
import com.tweet.tweet.entity.RegisterEntity;
import com.tweet.tweet.entity.UserTweetEntity;
import com.tweet.tweet.mapper.RegisterMapper;
import com.tweet.tweet.mapper.UserTweetMapper;
import com.tweet.tweet.repository.RegisterRepo;
import com.tweet.tweet.repository.UserTweetRepo;

@Service
public class UserTweetService {

	UserTweetRepo repo;
	UserTweetMapper mapper;
	RegisterRepo registerrepo;
	@Autowired
	RegisterMapper registermapper;
	
	
	@Autowired
	public void setRegisterrepo(RegisterRepo registerrepo) {
		this.registerrepo = registerrepo;
	}
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
		List<UserTweetEntity> list = repo.findAllByUser(loginId);
		List<String> strings = new ArrayList<String>();
		for (UserTweetEntity userTweetEntity : list) {
			strings.add(userTweetEntity.getTweet());
		}
		return strings;
	}
	
	public List<String> getAllUsers(){
		List<RegisterEntity> list = registerrepo.findAll();
		List<String> userList = new ArrayList<String>();
		for (RegisterEntity registerEntity : list) {
			userList.add(registerEntity.getLoginId());
		}
		return userList;
	}
	public String deleteTweet(String loginId, int tweetId) {
		if(repo.findById(tweetId).orElse(null) != null) {
			 repo.deleteById(tweetId);
				return "User Deleted";
		}
		return "No Such tweet ";
		
	}
	
	public UserTweetDTO changeTweet(String tweet, int tweetId , String loginId) {
		UserTweetEntity entity = repo.findTweet(tweetId , loginId).orElse(null);
		if(entity!= null) {
			entity.setTweet(tweet);
			repo.save(entity);
		}
		return mapper.entityToDto(entity);
	}
	
	public List<RegisterDTO> searchUser(String userId) {
		List<RegisterEntity> entity = registerrepo.searchUser(userId);
		return registermapper.entityToDto(entity);
	}
}

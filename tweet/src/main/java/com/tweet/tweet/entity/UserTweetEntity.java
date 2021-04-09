package com.tweet.tweet.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserTweetEntity {


    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	
	private String loginid;
	private String tweet;
	@Id
	private int tweetId;

	
	public UserTweetEntity() {
		
	}

	public UserTweetEntity( String tweet, int tweetId) {
		this.tweet = tweet;
		this.tweetId = tweetId;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	
	
}

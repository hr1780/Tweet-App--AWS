package com.tweet.tweet.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserTweetEntity {


    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	
	private String loginId;
	private String tweet;
	@Id
	private long tweetId;

	
	public UserTweetEntity() {
		
	}

	public UserTweetEntity( String tweet, long tweetId) {
		this.tweet = tweet;
		this.tweetId = tweetId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long l) {
		this.tweetId = l;
	}
	
	
}

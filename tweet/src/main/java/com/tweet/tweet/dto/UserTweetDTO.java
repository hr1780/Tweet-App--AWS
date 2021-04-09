package com.tweet.tweet.dto;



public class UserTweetDTO {

	private String loginid;
	private String tweet;
	private int tweetId;
	
	public UserTweetDTO() {
		
	}

	public UserTweetDTO(String loginid, String tweet, int tweetId) {
		this.loginid = loginid;
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

package com.tweet.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweet.tweet.entity.UserTweetEntity;

@Repository
public interface UserTweetRepo extends MongoRepository<UserTweetEntity, Integer> {

}

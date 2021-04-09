package com.tweet.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tweet.tweet.entity.RegisterEntity;

@Repository
public interface RegisterRepo extends MongoRepository<RegisterEntity, String> {
	
}

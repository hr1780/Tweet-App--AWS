package com.tweet.tweet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.tweet.entity.RegisterEntity;

@Repository
public interface LoginRepo extends MongoRepository<RegisterEntity, String> {

	@Query("{'loginId' : ?0 , 'password' : ?1}")
	public RegisterEntity login(String username , String password);
}

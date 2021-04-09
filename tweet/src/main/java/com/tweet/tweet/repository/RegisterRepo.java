package com.tweet.tweet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.tweet.entity.RegisterEntity;
import com.tweet.tweet.entity.UserTweetEntity;

@Repository
public interface RegisterRepo extends MongoRepository<RegisterEntity, String> {

	@Query(value = "{'loginId' : ?0 , 'email' : ?1}")
	RegisterEntity findUser(String loginId, String email);

	@Query("{'name' : userId}")
	List<RegisterEntity> searchUser(String userId);

	
}

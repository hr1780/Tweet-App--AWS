package com.tweet.tweet.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.tweet.entity.UserTweetEntity;

@Repository
public interface UserTweetRepo extends MongoRepository<UserTweetEntity, Integer> {
	
	@Query(value = "{'loginId' : ?0 }" , fields = "{'tweet' : 0}")
	List<String> findAllByUser(String loginId) ;

}

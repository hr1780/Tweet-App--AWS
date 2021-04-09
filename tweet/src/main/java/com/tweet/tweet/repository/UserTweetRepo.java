package com.tweet.tweet.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweet.tweet.entity.UserTweetEntity;

@Repository
public interface UserTweetRepo extends MongoRepository<UserTweetEntity, Integer> {
	
	@Query(value = "{'loginId' : ?0 }")
	List<UserTweetEntity> findAllByUser(String loginId) ;

	@Query(value = "{'tweetId' : ?0 , 'loginId' : ?1 }")
	Optional<UserTweetEntity> findTweet(int tweetId, String loginId);

}

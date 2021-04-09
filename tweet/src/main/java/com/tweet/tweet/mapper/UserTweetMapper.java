package com.tweet.tweet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tweet.tweet.dto.UserTweetDTO;
import com.tweet.tweet.entity.UserTweetEntity;

@Component
public class UserTweetMapper {

	
	public UserTweetDTO entityToDto(UserTweetEntity entity) {
		ModelMapper mapper =new ModelMapper();
		UserTweetDTO map = mapper.map(entity, UserTweetDTO.class);
		return map;
	}
	
public  List<UserTweetDTO> entityToDto(List<UserTweetEntity> entity) {
		
		return	entity.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}


public UserTweetEntity dtoToEntity(UserTweetDTO dto)
{
	ModelMapper mapper = new ModelMapper();
	UserTweetEntity map = mapper.map(dto, UserTweetEntity.class);
	return map;
}

public List<UserTweetEntity> dtoToEntity(List<UserTweetDTO> dto)
{
	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}

}

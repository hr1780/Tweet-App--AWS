package com.tweet.tweet.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tweet.tweet.dto.RegisterDTO;
import com.tweet.tweet.entity.RegisterEntity;

@Component
public class RegisterMapper {

	public RegisterDTO entityToDto(RegisterEntity entity) {
		ModelMapper mapper =new ModelMapper();
		RegisterDTO map = mapper.map(entity, RegisterDTO.class);
		return map;
	}
	
public  List<RegisterDTO> entityToDto(List<RegisterEntity> entity) {
		
		return	entity.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
	}


public RegisterEntity dtoToEntity(RegisterDTO dto)
{
	ModelMapper mapper = new ModelMapper();
	RegisterEntity map = mapper.map(dto, RegisterEntity.class);
	return map;
}

public List<RegisterEntity> dtoToEntity(List<RegisterDTO> dto)
{
	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}

}

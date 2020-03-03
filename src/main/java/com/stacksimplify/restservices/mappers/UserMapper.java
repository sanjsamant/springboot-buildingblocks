package com.stacksimplify.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;

//@Mapper(componentModel="spring")
@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	//User to UserMsDto
	//User has email field and UserMsDto has emailaddress field
	//If it is not mapped, emailaddress field will be returned null
	@Mappings({
	@Mapping(source = "email", target = "emailAddress"),
	@Mapping(source = "role", target = "rolename")
	})
	UserMsDto usertoUserMsDto(User user);
	
	//List<User> to List<UserMsDto>
	List<UserMsDto> usersToUserMsDtos(List<User> users);

}

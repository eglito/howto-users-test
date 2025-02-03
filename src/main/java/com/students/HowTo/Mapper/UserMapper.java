package com.students.HowTo.Mapper;

import com.students.HowTo.DTO.UserDto;
import com.students.HowTo.Domain.Model.UserModel;

public class UserMapper {
    
    UserDto userDtoMapper(UserModel user){
        return new UserDto(user.getEmail());
    }

    UserModel userMapper(UserDto userDto){
        return new UserModel(userDto.getEmail());
    }
}

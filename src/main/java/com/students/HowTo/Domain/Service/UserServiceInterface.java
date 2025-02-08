package com.students.HowTo.Domain.Service;

import com.students.HowTo.DTO.UserDto;
import com.students.HowTo.DTO.UserRequestDTO;

public interface UserServiceInterface {

    UserDto createUser(UserRequestDTO userRequestDTO) throws IllegalAccessException;
}

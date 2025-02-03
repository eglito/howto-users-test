package com.students.HowTo.Domain.Service;

import com.students.HowTo.Adapters.Output.Repository.UserPersistencyAdapter;
import com.students.HowTo.Adapters.Output.UserEntity;
import com.students.HowTo.DTO.UserDto;
import com.students.HowTo.DTO.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserPersistencyAdapter userPersistencyAdapter;

    public List<UserDto> getAllUsers(){

        List<UserEntity> users = userPersistencyAdapter.findAll();
        List<UserDto> response = users.stream()
                .map(user -> new UserDto(user.getEmail()))
                .toList();

        return response;
    }

    @Override
    public UserDto createUser(UserRequestDTO userRequestDTO) {
        userPersistencyAdapter.save(new UserEntity(userRequestDTO.getEmail(), userRequestDTO.getPasswordHash()));
        return new UserDto(userRequestDTO.getEmail());
    }


    public UserDto updateUser(Long id, UserRequestDTO userRequestDTO){
        UserEntity userEntity = userPersistencyAdapter.findById(id).get();
        userEntity.setEmail(userRequestDTO.getEmail());
        userEntity.setPasswordHash(userRequestDTO.getPasswordHash());

        userPersistencyAdapter.save(userEntity);

        return new UserDto(userEntity.getEmail());
    }

    public UserDto deleteUser(Long id){
        UserEntity userEntity = userPersistencyAdapter.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        UserDto userDto = new UserDto(userEntity.getEmail());
        userPersistencyAdapter.delete(userEntity);

        return userDto;
    }
}

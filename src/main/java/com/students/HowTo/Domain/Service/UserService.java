package com.students.HowTo.Domain.Service;

import com.students.HowTo.Adapters.Output.Repository.UserPersistencyAdapter;
import com.students.HowTo.Adapters.Output.UserEntity;
import com.students.HowTo.DTO.UserDto;
import com.students.HowTo.DTO.UserRequestDTO;
import com.students.HowTo.Domain.Service.PasswordService.PasswordBcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserPersistencyAdapter userPersistencyAdapter;
    @Autowired
    private PasswordBcrypt passwordBcrypt;

    public List<UserDto> getAllUsers(){

        List<UserEntity> users = userPersistencyAdapter.findAll();
        List<UserDto> response = users.stream()
                .map(user -> new UserDto(user.getEmail()))
                .toList();

        return response;
    }

    @Override
    public UserDto createUser(UserRequestDTO userRequestDTO) throws IllegalAccessException {

        String encryption = passwordBcrypt.passwordCrypt(userRequestDTO.getPasswordHash());

        Optional<UserEntity> optionalUser = userPersistencyAdapter.findByEmail(userRequestDTO.getEmail());
        if(optionalUser.isEmpty()){
            userPersistencyAdapter.save(new UserEntity(userRequestDTO.getEmail(), encryption));
        }

        return new UserDto(userRequestDTO.getEmail());
    }


    public UserDto updateUser(Long id, UserRequestDTO userRequestDTO){
        UserEntity userEntity = userPersistencyAdapter.findById(id).get();

        if(userEntity.getEmail() != userRequestDTO.getEmail()){
            userEntity.setEmail(userRequestDTO.getEmail());
        }
        if (userEntity.getPasswordHash() != userRequestDTO.getPasswordHash()){
            userEntity.setPasswordHash(userRequestDTO.getPasswordHash());
        }

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

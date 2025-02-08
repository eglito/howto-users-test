package com.students.HowTo.Adapters.Input.Rest;

import com.students.HowTo.DTO.UserDto;
import com.students.HowTo.DTO.UserRequestDTO;
import com.students.HowTo.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RestController
@RequestMapping("/new-user")
public class UserSignUpController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return  ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequestDTO userRequest) throws IllegalAccessException {

        UserDto userDto = userService.createUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequest){

        UserDto userDto = userService.updateUser(id, userRequest);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

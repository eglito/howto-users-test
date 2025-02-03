package com.students.HowTo.Adapters.Input.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.HowTo.Adapters.Output.Repository.UserPersistencyAdapter;


@RestController
@RequestMapping("/new-user")
public class UserController {
    
    private UserPersistencyAdapter userPersistencyAdapter;

  
    
}

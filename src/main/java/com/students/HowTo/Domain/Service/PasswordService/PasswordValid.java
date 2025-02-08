package com.students.HowTo.Domain.Service.PasswordService;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PasswordValid {

    private String password;

    public PasswordValid(){
        this.password = password;
    }

    public Boolean validPassoword(String password) throws IllegalAccessException {

        this.password = password;

        String regex = "^(?=.*\\d).{8,}$";
        if(Pattern.matches(regex, this.password)){
            return true;
        } throw new IllegalAccessException("A senha deve ter entre 8 e 30 caracteres " +
                                           "e conter uma letra maiúscula, um símbolo e um número");
    }
}
package com.students.HowTo.Domain.Service.PasswordService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordBcrypt {

    private PasswordValid passwordValid;
    private final PasswordEncoder encoder;

    public PasswordBcrypt(PasswordValid passwordValid, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.passwordValid = passwordValid;
    }

    public String passwordCrypt(String password) throws IllegalAccessException {

        if(this.passwordValid.validPassoword(password)){
            return encoder.encode(password);
        }
        return null;
    }

    public Boolean matches(String password, String comparePassword){
        return encoder.matches(password, comparePassword);
    }


}

package com.students.HowTo.Domain.Model;

public class UserModel {
    
    private String email;

    public UserModel(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

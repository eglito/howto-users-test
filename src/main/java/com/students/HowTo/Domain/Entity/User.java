package com.students.HowTo.Domain.Entity;

public class User {

    private Long Id;
    private String email;
    private Long passwordHash;

    public User(String email, Long passwordHash){
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailHash(String email) {
        this.email = email;
    }

    public Long getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(Long passwordHash) {
        this.passwordHash = passwordHash;
    }

}

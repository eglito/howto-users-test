package com.students.HowTo.Adapters.Output;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
//@AllArgsConstructor
//@NoArgsConstructor
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;

    @Column(name = "email",unique=true, nullable=false)
    private String email;

    @Column(name = "passwordHash", nullable=false)
    private String passwordHash;

    public UserEntity(String email, String passwordHash){
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public UserEntity(){

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}

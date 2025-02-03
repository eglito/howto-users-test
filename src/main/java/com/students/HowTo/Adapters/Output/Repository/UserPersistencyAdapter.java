package com.students.HowTo.Adapters.Output.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.HowTo.Adapters.Output.UserEntity;

public interface UserPersistencyAdapter extends JpaRepository<UserEntity, Long> {

}

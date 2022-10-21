package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoapi.demoapi.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    Boolean existsByUsername(String username);
}

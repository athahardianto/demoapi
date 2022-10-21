package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoapi.demoapi.model.Role;

public interface RoleRepository extends  JpaRepository<Role,Long>{
    Boolean existsByName(String name);
}

package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapi.demoapi.model.Role;

@Repository
public interface RoleRepository extends  JpaRepository<Role,Long>{
    Boolean existsByName(String name);
}

package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapi.demoapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsByName(String name);

    
}

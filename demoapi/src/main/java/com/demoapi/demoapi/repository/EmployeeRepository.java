package com.demoapi.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoapi.demoapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsByName(String name);
}

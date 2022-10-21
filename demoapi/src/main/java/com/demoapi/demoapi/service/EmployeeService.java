package com.demoapi.demoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demoapi.demoapi.model.Employee;
import com.demoapi.demoapi.repository.EmployeeRepository;

@Service 
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id)
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"employee not found!") );
    }

    public Employee create(Employee employee){
        if (employee.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "employee id already exists!");
        } 

        if(employeeRepository.existsByName(employee.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "employee name is already exists!");
        }

        return employeeRepository.save(employee);
    }
    
    public Employee update(Long id, Employee employee){
        getById(id);
        employee.setId(id);
        if(employeeRepository.existsByName(employee.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "employee name is already exists!");
        }
        return employeeRepository.save(employee);
    }
    
    public Employee delete(Long id){
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}

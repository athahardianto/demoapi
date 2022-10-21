package com.demoapi.demoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoapi.demoapi.service.EmployeeService;
import com.demoapi.demoapi.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity(employeeService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        return new ResponseEntity(employeeService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> Create(@RequestBody Employee employee){
        return new ResponseEntity(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> Update(@PathVariable Long id,@RequestBody Employee employee){
        return new ResponseEntity(employeeService.update(id,employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> Delete(@PathVariable Long id){
        return new ResponseEntity(employeeService.delete(id), HttpStatus.OK);
    }
}

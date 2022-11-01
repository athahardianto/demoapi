package com.demoapi.demoapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demoapi.demoapi.model.Employee;
import com.demoapi.demoapi.model.Role;
import com.demoapi.demoapi.model.User;
import com.demoapi.demoapi.model.dto.request.EmployeeRequest;
import com.demoapi.demoapi.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private RoleService roleService;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    // ModelMapper (JUMAT)
    public Employee create(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setNumber(employeeRequest.getNumber());
        
        User user = new User();
        user.setUsername(employeeRequest.getUsername());
        user.setPassword(employeeRequest.getPassword());
     
        List<Role> role = new ArrayList<>();
        role.add(roleService.getById(2L));
        user.setRole(role);
        
        employee.setUser(user);
        user.setEmployee(employee);
        
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        getById(id);
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    
    public Employee delete(Long id){
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}

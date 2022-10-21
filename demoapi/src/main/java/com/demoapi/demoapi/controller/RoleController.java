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

import com.demoapi.demoapi.model.Role;
import com.demoapi.demoapi.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;
    
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll(){
        return new ResponseEntity(roleService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Role> getById(@PathVariable Long id){
        return new ResponseEntity(roleService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Role> Create(@RequestBody Role role){
        return new ResponseEntity(roleService.create(role), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> Update(@PathVariable Long id,@RequestBody Role role){
        return new ResponseEntity(roleService.update(id,role), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> Delete(@PathVariable Long id){
        return new ResponseEntity(roleService.delete(id), HttpStatus.OK);
    }
}

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

import com.demoapi.demoapi.model.User;
import com.demoapi.demoapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity(userService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<User> getById(@PathVariable Long id){
        return new ResponseEntity(userService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> Create(@RequestBody User user){
        return new ResponseEntity(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> Update(@PathVariable Long id,@RequestBody User user){
        return new ResponseEntity(userService.update(id,user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> Delete(@PathVariable Long id){
        return new ResponseEntity(userService.delete(id), HttpStatus.OK);
    }
}

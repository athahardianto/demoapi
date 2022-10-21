package com.demoapi.demoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demoapi.demoapi.model.User;
import com.demoapi.demoapi.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id)
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found!") );
    }

    public User create(User user){
        if (user.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User id already exists!");
        } 

        if(userRepository.existsByUsername(user.getUsername()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User name is already exists!");
        }

        return userRepository.save(user);
    }
    
    public User update(Long id, User user){
        getById(id);
        user.setId(id);
        if(userRepository.existsByUsername(user.getUsername()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User name is already exists!");
        }
        return userRepository.save(user);
    }
    
    public User delete(Long id){
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}

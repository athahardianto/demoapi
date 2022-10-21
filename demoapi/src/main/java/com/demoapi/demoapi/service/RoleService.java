package com.demoapi.demoapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demoapi.demoapi.model.Role;
import com.demoapi.demoapi.repository.RoleRepository;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role getById(Long id){
        return roleRepository.findById(id)
            .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Role not found!") );
    }

    public Role create(Role role){
        if (role.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role id already exists!");
        } 

        if(roleRepository.existsByName(role.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role name is already exists!");
        }

        return roleRepository.save(role);
    }
    
    public Role update(Long id, Role role){
        getById(id);
        role.setId(id);
        if(roleRepository.existsByName(role.getName()) ){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role name is already exists!");
        }
        return roleRepository.save(role);
    }
    
    public Role delete(Long id){
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }
}

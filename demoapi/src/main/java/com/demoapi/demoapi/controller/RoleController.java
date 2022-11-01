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

    @GetMapping // http:/localhost:8088/role
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}") // http:/localhost:8088/role/1
    public Role getById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @PostMapping // http:/localhost:8088/role
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping("/{id}") // http:/localhost:8088/role/1
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        return roleService.update(id, role);
    }

    @DeleteMapping("/{id}") // http:/localhost:8088/role/1
    public Role delete(@PathVariable Long id) {
        return roleService.delete(id);
    }
}

package com.demoapi.demoapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "tb_user")
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;

    @OneToOne
    @MapsId
    // @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(mappedBy = "user")
    // @JoinTable(
    // name = "tb_user_role", 
    // joinColumns = @JoinColumn(name = "employee_id"), 
    // inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY )
    private List<Role>role;
    // @OneToMany(mappedBy ="user")
    // private List<UserRole> userRole;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    // public List<UserRole> getUserRole() {
    //     return userRole;
    // }

    // public void setUserRole(List<UserRole> userRole) {
    //     this.userRole = userRole;
    // }
    
    
    

    

}

// package com.demoapi.demoapi.model;

// import javax.persistence.EmbeddedId;
// import javax.persistence.Entity;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.MapsId;

// @Entity
// public class UserRole {

//     @EmbeddedId
//     UserRoleKey id;
    
//     @ManyToOne
//     @MapsId("userId")
//     @JoinColumn(name="employee_id")
//     User user;

//     @ManyToOne
//     @MapsId("roleId")
//     @JoinColumn(name="role_id")
//     Role role;

//     public UserRole() {
//     }

//     public UserRoleKey getId() {
//         return id;
//     }

//     public void setId(UserRoleKey id) {
//         this.id = id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public Role getRole() {
//         return role;
//     }

//     public void setRole(Role role) {
//         this.role = role;
//     }

    
// }

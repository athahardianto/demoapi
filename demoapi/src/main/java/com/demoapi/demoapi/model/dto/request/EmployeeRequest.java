package com.demoapi.demoapi.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private String name;
    private String email;
    private int number;
    private String username;
    private String password;
}

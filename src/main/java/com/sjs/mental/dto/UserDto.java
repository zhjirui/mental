package com.sjs.mental.dto;

import com.sjs.mental.model.Department;
import com.sjs.mental.model.Role;
import com.sjs.mental.model.User;

/**
 *
 */
public class UserDto extends User {

    private String username;

    private Role role;

    private Department department;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}

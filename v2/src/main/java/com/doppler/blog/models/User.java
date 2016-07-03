package com.doppler.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by doppler on 2016/5/19.
 */
public class User extends BaseModel {

    private static final long serialVersionUID = -9127607570454530499L;
    public static final String ROLE_ADMIN = "ADMIN";
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private String role = ROLE_ADMIN;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

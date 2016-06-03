package com.doppler.blog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by doppler on 2016/5/19.
 */
@Document
public class User extends BaseModel {

    private static final long serialVersionUID = -9127607570454530499L;
    @Field(value = "username")
    private String username;
    @Field(value = "email")
    private String email;
    @JsonIgnore
    @Field(value = "password")
    private String password;
    @Field(value = "role")
    private String role = "ADMIN";


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

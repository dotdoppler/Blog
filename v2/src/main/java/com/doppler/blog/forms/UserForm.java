package com.doppler.blog.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserForm {
    @NotNull
    private String password;

    @NotNull
    private String newPassword;

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

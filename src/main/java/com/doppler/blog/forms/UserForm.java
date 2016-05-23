package com.doppler.blog.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Raysmond<i@raysmond.com>.
 */
@Data
public class UserForm {
    @NotNull
    private String password;

    @NotNull
    private String newPassword;

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
}

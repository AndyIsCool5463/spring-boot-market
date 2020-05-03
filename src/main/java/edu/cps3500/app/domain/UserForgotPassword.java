package edu.cps3500.app.domain;

import javax.validation.constraints.NotEmpty;

public class UserForgotPassword {
    @NotEmpty
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
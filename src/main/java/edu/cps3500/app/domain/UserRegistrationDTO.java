package edu.cps3500.app.domain;

import javax.validation.constraints.NotEmpty;

public class UserRegistrationDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @NotEmpty
    private String email;

    @NotEmpty
    private String confirmEmail;

    private Boolean terms;

    public Boolean getTerms() {
        return this.terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public String getConfirmEmail() {
        return this.confirmEmail;
    }

    // I wont be adding any setters.
    // haha just kidding i am 3 hours later
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
}
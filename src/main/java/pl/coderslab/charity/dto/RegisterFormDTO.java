package pl.coderslab.charity.dto;

import pl.coderslab.charity.model.User;

import javax.validation.constraints.NotBlank;

public class RegisterFormDTO {

    @NotBlank(message = "Pole nie moze byc puste")
    private String email;
    @NotBlank(message = "Pole nie moze byc puste")
    private String password;
    @NotBlank(message = "Pole nie moze byc puste")
    private String rePassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}

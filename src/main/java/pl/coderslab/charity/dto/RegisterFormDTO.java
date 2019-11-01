package pl.coderslab.charity.dto;

import javax.validation.constraints.NotBlank;

public class RegisterFormDTO {

    @NotBlank(message = "Pole nie moze byc puste")
    private String email;
    @NotBlank(message = "Pole nie moze byc puste")
    private String password;
    @NotBlank(message = "Pole nie moze byc puste")
    private String rePassword;

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

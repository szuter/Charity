package pl.coderslab.charity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginFormDTO {


    @Email
    @NotBlank(message = "Pole nie moze buc puste")
    private String email;
    @NotBlank(message = "Pole nie moze buc puste")
    private String password;

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
}

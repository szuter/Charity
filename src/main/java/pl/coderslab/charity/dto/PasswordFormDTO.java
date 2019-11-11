package pl.coderslab.charity.dto;

import javax.validation.constraints.NotBlank;

public class PasswordFormDTO {

    private Long id;
    @NotBlank(message = "Wypełnij pole")
    private String actualPassword;
    @NotBlank(message = "Wypełnij pole")
    private String newPassword;
    @NotBlank(message = "Wypełnij pole")
    private String reNewPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActualPassword() {
        return actualPassword;
    }

    public void setActualPassword(String actualPassword) {
        this.actualPassword = actualPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}

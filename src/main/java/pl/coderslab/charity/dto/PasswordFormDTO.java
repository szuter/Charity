package pl.coderslab.charity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PasswordFormDTO {

    private Long id;
    @NotBlank(message = "Wypełnij pole")
    private String actualPassword;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,12}$", message = "Hasło musi posiadać conajmniej jeden znak specjalny, jedną duża literę i składać się z 8-12 znaków")
    private String newPassword;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,12}$", message = "Hasło musi posiadać conajmniej jeden znak specjalny, jedną duża literę i składać się z 8-12 znaków")
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

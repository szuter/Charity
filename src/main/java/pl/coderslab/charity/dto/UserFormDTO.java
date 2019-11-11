package pl.coderslab.charity.dto;

import javax.validation.constraints.NotBlank;

public class UserFormDTO {

    private Long id;
    @NotBlank(message = "Pole nie może byc puste")
    private String firstName;
    @NotBlank(message = "Pole nie może byc puste")
    private String lastName;
    private String access;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
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
}

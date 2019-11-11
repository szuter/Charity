package pl.coderslab.charity.dto;

import javax.validation.constraints.NotBlank;

public class InstitutionFormDTO {

    private Long id;
    @NotBlank(message = "Wypełnij pole")
    private String name;
    @NotBlank(message = "Wypełnij pole")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

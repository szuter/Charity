package pl.coderslab.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "institutions")
public class Institution extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
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
}

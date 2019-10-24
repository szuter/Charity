package pl.coderslab.charity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Donation> donations = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

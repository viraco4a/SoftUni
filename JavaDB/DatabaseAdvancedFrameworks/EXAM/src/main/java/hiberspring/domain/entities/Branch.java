package hiberspring.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "branches")
public class Branch extends BaseEntity {
    private String name;
    private Town town;
    private List<Product> products;

    public Branch() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(
            targetEntity = Town.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "town_id",
            nullable = false,
            referencedColumnName = "id"

    )
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "branch",
            cascade = CascadeType.ALL
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

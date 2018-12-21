package hiberspring.domain.entities;

import javax.persistence.*;

@Entity(name = "products")
public class Product extends BaseEntity{
    private String name;
    private Integer clients;
    private Branch branch;

    public Product() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "clients", nullable = false)
    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    @ManyToOne(
            targetEntity = Branch.class,
            cascade = CascadeType.ALL
    )  //maybe ManyToMany?
    @JoinColumn(
            name = "branch_id",
            nullable = false,
            referencedColumnName = "id"
    )
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}

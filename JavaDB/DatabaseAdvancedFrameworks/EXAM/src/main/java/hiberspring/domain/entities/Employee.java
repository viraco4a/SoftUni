package hiberspring.domain.entities;

import javax.persistence.*;

@Entity(name = "employees")
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String position;
    private EmployeeCard card;
    private Branch branch;

    public Employee() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "position", nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @OneToOne(
            targetEntity = EmployeeCard.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "card_id",
            unique = true,
            nullable = false,
            referencedColumnName = "id"
    )
    public EmployeeCard getCard() {
        return card;
    }

    public void setCard(EmployeeCard card) {
        this.card = card;
    }

    @ManyToOne(
            targetEntity = Branch.class,
            cascade = CascadeType.ALL
    )
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

package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {
    private User owner;

    public BillingDetail() {
    }

    @ManyToOne(
            targetEntity = User.class,
            cascade = CascadeType.ALL
    )
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}

package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String firstName;
    private String last_Name;
    private String email;
    private String password;
    private BillingDetail billingDetail;
    //TODO add constructor, get set, annotations
}

package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String first_name;
    private String last_name;
    private String address;
    //TODO
}

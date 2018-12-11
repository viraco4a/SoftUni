package entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private long id;
    private String number;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "number", unique = true, length = 30)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

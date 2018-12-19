package mostwanted.domain.entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity(name = "racers")
public class Racer extends BaseEntity{
    private String name;
    private Integer age;
    private BigDecimal bounty;
    private Town homeTown;
    //TODO
}

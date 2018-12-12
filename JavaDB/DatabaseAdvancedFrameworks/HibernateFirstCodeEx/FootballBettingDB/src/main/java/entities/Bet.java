package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {
    private Double betMoney;
    private Date dateTime;
    private User user;

    public Bet() {
    }

    @Column(name = "bet_money", nullable = false)
    public Double getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(Double betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time", nullable = false)
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne(
            targetEntity = User.class,
            cascade = CascadeType.ALL
    )
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

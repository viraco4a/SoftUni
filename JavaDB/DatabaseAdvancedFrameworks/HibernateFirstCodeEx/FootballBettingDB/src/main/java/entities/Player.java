package entities;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
    private String name;
    private int squadNumber;
    private Team team;
    private Position position;
    private boolean isInjured;

    public Player() {
    }

    @Column(name = "name", nullable = false, unique = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "squad_number", nullable = false, unique = true, length = 30)
    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne(
            targetEntity = Team.class,
            cascade = CascadeType.ALL
    )
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne(
            targetEntity = Position.class,
            cascade = CascadeType.ALL
    )
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "is_injured", nullable = false)
    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }
}

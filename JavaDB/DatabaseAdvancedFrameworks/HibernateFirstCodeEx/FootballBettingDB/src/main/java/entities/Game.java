package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private Date dateTime;
    private Double homeTeamWinBetRate;
    private Double awayTeamWinBetRate;
    private Double drawGameBetRate;
    private Round round;
    private Competition competition;

    public Game() {
    }

    @OneToOne(
            targetEntity = Team.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "home_team")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @OneToOne(
            targetEntity = Team.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "away_team")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "away_team_goals")
    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column(name = "date_time")
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "home_team_win_bet_rate")
    public Double getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(Double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate")
    public Double getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(Double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_game_bet_rate")
    public Double getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(Double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @ManyToOne(
            targetEntity = Round.class,
            cascade = CascadeType.ALL
    )
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne(
            targetEntity = Competition.class,
            cascade = CascadeType.ALL
    )
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}

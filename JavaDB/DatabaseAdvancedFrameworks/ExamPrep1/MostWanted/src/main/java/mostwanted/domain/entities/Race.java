package mostwanted.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "races")
public class Race extends BaseEntity{
    private Integer laps;
    private District district;
    private List<RaceEntry> entries;

    public Race() {
    }

    @Column(name = "laps", nullable = false, columnDefinition = "INT(11) default 0")
    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    @ManyToOne(
            targetEntity = District.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "district_id",
            referencedColumnName = "id",
            nullable = false
    )
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @OneToMany(
            mappedBy = "race",
            targetEntity = RaceEntry.class,
            cascade = CascadeType.ALL
    )
    public List<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<RaceEntry> entries) {
        this.entries = entries;
    }
}

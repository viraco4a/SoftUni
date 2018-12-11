package entities;

import org.hibernate.engine.internal.TwoPhaseLoad;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
    private String name;
    private byte[] logo;
    private String initials;
    private Color primaryKitColor;
    private Color secondaryKitColor;
    private BigDecimal budget;
    private Town town;

    public Team() {
    }

    @Column(name = "name", unique = true, nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(name = "logo", length = 50000)
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Column(name = "initials", length = 3)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @ManyToOne
    @JoinColumn(name = "primary_kit_color_id")
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color_id")
    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    @Column(name = "budget")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = Town.class
    )
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}

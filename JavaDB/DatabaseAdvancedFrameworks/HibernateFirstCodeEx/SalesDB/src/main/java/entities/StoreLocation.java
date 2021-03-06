package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation extends BaseEntity {

    private String locationName;
    private Set<Sale> sales;

    public StoreLocation() {
    }

    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(
            targetEntity = Sale.class,
            mappedBy = "storeLocation",
            cascade = CascadeType.ALL
    )
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}

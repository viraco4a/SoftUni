package mostwanted.domain.dtos;

import com.google.gson.annotations.Expose;
import com.sun.istack.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarImportDto {
    @Expose
    private String brand;

    @Expose
    private String model;

    @Expose
    private BigDecimal price;

    @Expose
    private LocalDate yearOfProduction;

    @Expose
    private Double maxSpeed;

    @Expose
    private String zeroToSixty;

    @Expose
    private String racerName;

    public CarImportDto() {
    }

    @NotNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @NotNull
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public LocalDate getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(LocalDate yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getZeroToSixty() {
        return zeroToSixty;
    }

    public void setZeroToSixty(String zeroToSixty) {
        this.zeroToSixty = zeroToSixty;
    }

    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }
}

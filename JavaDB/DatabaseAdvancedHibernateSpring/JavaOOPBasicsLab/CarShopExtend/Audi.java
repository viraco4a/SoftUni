package CarShopExtend;

public class Audi extends Rentable implements Car {
    private String model;
    private String color;
    private Integer horsePower;
    private String country;


    public Audi(String model, String color, int horsePower, String country,
                Integer minRentDays, double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
        this.pricePerDay = price;
        this.minRentDays = minRentDays;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public Double getPricePerDay() {
        return this.getPricePerDay();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString(){
        return String.format(
                "This is %s produced in %s and have %d tires",
                this.getModel(),
                this.country,
                this.TIRES);
    }
}

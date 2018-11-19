package CarShop;

public class Seat implements Car, Serializable {
    private String model;
    private String color;
    private Integer horsePower;
    private String country;

    public Seat(String model, String color, int horsePower, String country) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
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

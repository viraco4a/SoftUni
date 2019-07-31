package car_shop_extended;

public interface Rentable extends Car {
    Integer getMinRentDay();

    Double getPricePerDay();
}

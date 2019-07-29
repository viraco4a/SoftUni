package HotelReservation;

public enum Discount {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private int discountPercentage;

    Discount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }
}

package HotelReservation;

public class PriceCalculator {
    public static double calculate(Reservation reservation) {
        return reservation.getPricePerDay()
                * reservation.getNumberOfDays()
                * reservation.getSeason().getMultiplier()
                * (1 - 0.01 * (reservation.getDiscount().getDiscountPercentage()));

    }
}

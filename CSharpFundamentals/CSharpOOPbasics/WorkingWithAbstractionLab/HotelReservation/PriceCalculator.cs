namespace HotelReservation
{
    public class PriceCalculator
    {
        public static decimal CalculatePrice(decimal pricePerDay,
            int numberOfdays, Season season, Discount discount)
        {
            int multiplier = (int)season;
            decimal discountMult = (decimal)discount / 100;

            decimal priceBeforeDiscount = pricePerDay * numberOfdays * multiplier;
            decimal discountedAmount = priceBeforeDiscount * discountMult;
            decimal finalPrice = priceBeforeDiscount - discountedAmount;

            return finalPrice;
        }
    }
}

using System;

namespace HotelReservation
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().Split();
            decimal pricePerDay = decimal.Parse(input[0]);
            int numberOfDays = int.Parse(input[1]);
            string seasonData = input[2];
            string discountType = "";
            if (input.Length == 3)
            {
                discountType = "None";
            }
            else
            {
                discountType = input[3];
            }
            decimal price = PriceCalculator.CalculatePrice(
                pricePerDay,
                numberOfDays, 
                Enum.Parse<Season>(seasonData),
                Enum.Parse<Discount>(discountType));
            Console.WriteLine($"{price:F2}");
        }
    }
}

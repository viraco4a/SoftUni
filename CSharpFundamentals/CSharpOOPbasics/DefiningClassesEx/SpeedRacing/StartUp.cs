using System;
using System.Collections.Generic;
using System.Linq;

namespace SpeedRacing
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            var cars = new Dictionary<string, Car>();

            GetCars(cars);

            MoveCars(cars);

            cars
                .ToList()
                .ForEach(x =>
                {
                    Console.WriteLine($"{x.Key} {x.Value.FuelAmount:F2} {x.Value.TraveledDistance}");
                });
        }

        private static void MoveCars(Dictionary<string, Car> cars)
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                var splitted = input.Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string carToDrive = splitted[1];
                int amountOfKm = int.Parse(splitted[2]);
                Car car = cars[carToDrive];
                if (car.CanMove(amountOfKm))
                {
                    car.FuelAmount -= amountOfKm * car.FuelConsumption;
                    car.TraveledDistance += amountOfKm;
                }
                else
                {
                    Console.WriteLine("Insufficient fuel for the drive");
                }
                input = Console.ReadLine();
            }
        }

        private static void GetCars(Dictionary<string, Car> cars)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string model = input[0];
                double fuelAmount = double.Parse(input[1]);
                double fuelConsumption = double.Parse(input[2]);
                var newCar = new Car(model, fuelAmount, fuelConsumption, 0);
                cars.Add(model, newCar);
            }
        }
    }
}

using System;

namespace Vehicles
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            string[] carData = Console.ReadLine().Split();
            string[] truckData = Console.ReadLine().Split();

            Vehicle car = new Car(double.Parse(carData[1]), double.Parse(carData[2]));
            Vehicle truck = new Truck(double.Parse(truckData[1]), double.Parse(truckData[2]));

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] command = Console.ReadLine().Split();
                double arg = double.Parse(command[2]);
                if (command[0] == "Drive")
                {
                    if (command[1] == "Car")
                    {
                        car.Drive(arg);
                    }
                    else if (command[1] == "Truck")
                    {
                        truck.Drive(arg);
                    }
                }
                else if (command[0] == "Refuel")
                {
                    if (command[1] == "Car")
                    {
                        car.Refuel(arg);
                    }
                    else if (command[1] == "Truck")
                    {
                        truck.Refuel(arg);
                    }
                }
            }

            Console.WriteLine($"Car: {car.FuelQuantity:F2}");
            Console.WriteLine($"Truck: {truck.FuelQuantity:F2}");
        }
    }
}

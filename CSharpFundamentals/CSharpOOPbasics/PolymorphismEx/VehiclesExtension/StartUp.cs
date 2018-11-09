using System;

namespace Vehicles
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            string[] carData = Console.ReadLine().Split();
            string[] truckData = Console.ReadLine().Split();
            string[] busData = Console.ReadLine().Split();

            Vehicle car = new Car(double.Parse(carData[1]),
                                  double.Parse(carData[2]),
                                  double.Parse(carData[3]));
            Vehicle truck = new Truck(double.Parse(truckData[1]),
                                      double.Parse(truckData[2]),
                                      double.Parse(truckData[3]));
            Bus bus = new Bus(double.Parse(busData[1]),
                          double.Parse(busData[2]),
                          double.Parse(busData[3]));

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] command = Console.ReadLine().Split();
                double arg = double.Parse(command[2]);
                try
                {
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
                        else if (command[1] == "Bus")
                        {
                            bus.IsEmpty = false;
                            bus.Drive(arg);
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
                        else if (command[1] == "Bus")
                        {
                            bus.Refuel(arg);
                        }
                    }
                    else
                    {
                        bus.IsEmpty = true;
                        bus.Drive(arg);
                    }
                }
                catch (ArgumentException ae)
                {
                    Console.WriteLine(ae.Message);
                }
            }

            Console.WriteLine($"Car: {car.FuelQuantity:F2}");
            Console.WriteLine($"Truck: {truck.FuelQuantity:F2}");
            Console.WriteLine($"Bus: {bus.FuelQuantity:F2}");
        }
    }
}

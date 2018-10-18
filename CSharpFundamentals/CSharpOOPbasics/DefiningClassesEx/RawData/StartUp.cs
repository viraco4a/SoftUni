using System;
using System.Collections.Generic;
using System.Linq;

namespace RawData
{
    public class StartUp
    {
        public static List<Car> cars;
        public static void Main(string[] args)
        {
            cars = new List<Car>();

            ReadCars();

            string command = Console.ReadLine();

            if (command == "fragile")
            {
                cars.Where(s => s.Cargo.Type == "fragile" && s.Tires.Any(x => x.Pressure < 1))
                    .ToList()
                    .ForEach(c =>
                    {
                        Console.WriteLine(c.Model);
                    });
            }
            else if (command == "flamable")
            {
                cars.Where(s => s.Cargo.Type == "flamable" && s.Engine.Power > 250)
                    .ToList()
                    .ForEach(c =>
                    {
                        Console.WriteLine(c.Model);
                    });
            }
        }

        private static void ReadCars()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                var input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);

                string model = input[0];
                int engineSpeed = int.Parse(input[1]);
                int enginePower = int.Parse(input[2]);
                int cargoWeight = int.Parse(input[3]);
                string cargoType = input[4];

                List<Tire> tires = new List<Tire>();

                for (int j = 0; j < 4; j+=2)
                {
                    double tirePressure = double.Parse(input[5 + j]);
                    int tireAge = int.Parse(input[5 + j + 1]);

                    Tire tire = new Tire(tireAge, tirePressure);

                    tires.Add(tire);
                }

                Engine engine = new Engine(engineSpeed, enginePower);
                Cargo cargo = new Cargo(cargoType, cargoWeight);
                Car car = new Car(model, engine, cargo, tires);

                cars.Add(car);
            }
        }
    }
}

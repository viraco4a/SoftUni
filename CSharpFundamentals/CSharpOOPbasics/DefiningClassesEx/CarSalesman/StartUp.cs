using System;
using System.Collections.Generic;
using System.Linq;

namespace CarSalesman
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            var engines = new List<Engine>();
            var cars = new List<Car>();

            ReadEngines(engines);

            ReadCars(engines, cars);

            cars.ForEach(c =>
            {
                Console.WriteLine(c.ToString());
            });
        }

        private static void ReadCars(List<Engine> engines, List<Car> cars)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var carData = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string model = carData[0];
                string engineName = carData[1];
                Car car = new Car(model, engines.FirstOrDefault(s => s.Model == engineName));

                if (carData.Length > 2)
                {
                    if (int.TryParse(carData[2], out int weightInt))
                    {
                        string weight = weightInt.ToString();
                        car.Weight = weight;
                    }
                    else
                    {
                        string color = carData[2];
                        car.Color = color;
                    }
                }
                if (carData.Length > 3)
                {
                    string weight = carData[2];
                    car.Weight = weight;
                    string color = carData[3];
                    car.Color = color;
                }
                cars.Add(car);
            }
        }

        private static void ReadEngines(List<Engine> engines)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                var engineData = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string model = engineData[0];
                int power = int.Parse(engineData[1]);
                Engine engine = new Engine(model, power);

                if (engineData.Length > 2)
                {
                    if (int.TryParse(engineData[2], out int displacementInt))
                    {
                        string displacement = displacementInt.ToString();
                        engine.Displacement = displacement;
                    }
                    else
                    {
                        string efficiency = engineData[2];
                        engine.Efficiency = efficiency;
                    }
                }
                if (engineData.Length > 3)
                {
                    string displacement = engineData[2];
                    engine.Displacement = displacement;
                    string efficiency = engineData[3];
                    engine.Efficiency = efficiency;
                }
                engines.Add(engine);
            }
        }
    }
}

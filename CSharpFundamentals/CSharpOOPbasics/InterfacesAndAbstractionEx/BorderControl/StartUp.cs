using System;
using System.Collections.Generic;
using System.Linq;

namespace BorderControl
{
    class StartUp
    {
        private static List<ITraceble> population = new List<ITraceble>();

        static void Main(string[] args)
        {
            ReadInput();

            string keyWord = Console.ReadLine();

            population
                .Where(s => s.Id.EndsWith(keyWord))
                .ToList()
                .ForEach(e =>
                {
                    Console.WriteLine(e.Id);
                });
        }

        private static void ReadInput()
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                string[] splitted = input.Split();

                if (splitted.Length == 2)
                {
                    string model = splitted[0];
                    string id = splitted[1];
                    ITraceble robot = new Robot(model, id);
                    population.Add(robot);
                }
                else
                {
                    string name = splitted[0];
                    int age = int.Parse(splitted[1]);
                    string id = splitted[2];
                    ITraceble citizen = new Citizen(name, age, id);
                    population.Add(citizen);
                }

                input = Console.ReadLine();
            }
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;

namespace FoodShortage
{
    public class StartUp
    {
        private static Dictionary<string, IBuyer> population = new Dictionary<string, IBuyer>();

        static void Main(string[] args)
        {
            Populate();

            PurchaseFood();

            Console.WriteLine(population.Sum(s => s.Value.Food));
        }

        private static void PurchaseFood()
        {
            string command = Console.ReadLine();

            while (command != "End")
            {
                if (population.ContainsKey(command))
                {
                    population[command].BuyFood();
                }
                command = Console.ReadLine();
            }
        }

        private static void Populate()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string[] splitted = Console.ReadLine().Split();

                switch (splitted.Length)
                {
                    case 4:
                        string name = splitted[0];
                        int age = int.Parse(splitted[1]);
                        string id = splitted[2];
                        string birthday = splitted[3];
                        try
                        {
                            if (!population.ContainsKey(name))
                            {
                                IBuyer citizen = new Citizen(name, age, id, birthday);
                                population.Add(name, citizen);
                            }
                        }
                        catch (ArgumentException) { }
                        break;
                    case 3:
                        name = splitted[0];
                        age = int.Parse(splitted[1]);
                        string group = splitted[2];
                        try
                        {
                            if (!population.ContainsKey(name))
                            {
                                IBuyer rebel = new Rebel(name, age, group);
                                population.Add(name, rebel);
                            }
                        }
                        catch (ArgumentException) { }
                        break;
                }
            }
        }
    }
}

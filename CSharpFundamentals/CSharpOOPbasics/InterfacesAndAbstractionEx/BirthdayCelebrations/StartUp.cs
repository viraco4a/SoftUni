using System;
using System.Collections.Generic;
using System.Linq;

namespace BirthdayCelebrations
{
    class StartUp
    {
        private static List<IBreedable> population = new List<IBreedable>();

        static void Main(string[] args)
        {
            ReadInput();

            string keyWord = Console.ReadLine();

            population
                .Where(s => s.Birthday.EndsWith(keyWord))
                .ToList()
                .ForEach(e =>
                {
                    Console.WriteLine(e.Birthday);
                });
        }

        private static void ReadInput()
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                string[] splitted = input.Split();

                switch (splitted[0])
                {
                    case "Citizen":
                        string name = splitted[1];
                        int age = int.Parse(splitted[2]);
                        string id = splitted[3];
                        string birthday = splitted[4];
                        IBreedable citizen = new Citizen(name, age, id, birthday);
                        population.Add(citizen);
                        break;
                    case "Pet":
                        name = splitted[1];
                        birthday = splitted[2];
                        IBreedable pet = new Pet(name, birthday);
                        population.Add(pet);
                        break;
                }

                input = Console.ReadLine();
            }
        }
    }
}
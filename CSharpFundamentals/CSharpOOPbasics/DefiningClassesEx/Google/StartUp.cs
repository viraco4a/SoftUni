using System;
using System.Collections.Generic;
using System.Linq;

namespace Google
{
    public class StartUp
    {
        public static Dictionary<string, Person> persons = new Dictionary<string, Person>();
        public static void Main(string[] args)
        {
            ReadInput();
            string person = Console.ReadLine();
            Console.WriteLine(persons[person].ToString());
        }

        private static void ReadInput()
        {
            string input = Console.ReadLine();
            while (input != "End")
            {
                string[] splitted = input
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string name = splitted[0];
                string command = splitted[1];
                switch (command)
                {
                    case "company":
                        string companyName = splitted[2];
                        string department = splitted[3];
                        decimal salary = decimal.Parse(splitted[4]);
                        if (!persons.ContainsKey(name))
                        {
                            persons.Add(name, new Person(name));
                        }
                        persons[name].Company = new Company(companyName, department, salary);
                        break;
                    case "pokemon":
                        string pokemonName = splitted[2];
                        string pokemonType = splitted[3];
                        if (!persons.ContainsKey(name))
                        {
                            persons.Add(name, new Person(name));
                        }
                        persons[name].Pokemons.Add(new Pokemon(pokemonName, pokemonType));
                        break;
                    case "parents":
                        string parentName = splitted[2];
                        string parentBirthday = splitted[3];
                        if (!persons.ContainsKey(name))
                        {
                            persons.Add(name, new Person(name));
                        }
                        persons[name].Parents.Add(new Relative(parentName, parentBirthday));
                        break;
                    case "children":
                        string childName = splitted[2];
                        string childBirthday = splitted[3];
                        if (!persons.ContainsKey(name))
                        {
                            persons.Add(name, new Person(name));
                        }
                        persons[name].Children.Add(new Relative(childName, childBirthday));
                        break;
                    case "car":
                        string carModel = splitted[2];
                        double carSpeed = double.Parse(splitted[3]);
                        if (!persons.ContainsKey(name))
                        {
                            persons.Add(name, new Person(name));
                        }
                        persons[name].Car = new Car(carModel, carSpeed);
                        break;
                }

                input = Console.ReadLine();
            }
        }
    }
}

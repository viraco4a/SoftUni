using System;

namespace ExplicitInterfaces
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            while (input != "End")
            {
                string[] splitted = input.Split();
                string name = splitted[0];
                string country = splitted[1];
                int age = int.Parse(splitted[2]);

                Citizen citizen = new Citizen(name, country, age);

                IPerson person = citizen;
                Console.WriteLine(person.GetName());

                IResident resident = citizen;
                Console.WriteLine(resident.GetName());

                input = Console.ReadLine();
            }
        }
    }
}

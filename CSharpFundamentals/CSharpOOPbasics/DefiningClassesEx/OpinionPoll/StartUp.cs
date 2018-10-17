using System;
using System.Linq;

namespace DefiningClasses
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            Family family = new Family();

            ReadInput(family);

            family
                .FamilyMembers
                .Where(m => m.Age > 30)
                .OrderBy(s => s.Name)
                .ToList()
                .ForEach(e =>
                {
                    Console.WriteLine($"{e.Name} - {e.Age}");
                });
        }

        private static void ReadInput(Family family)
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string[] input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string localName = input[0];
                int logalAge = int.Parse(input[1]);
                Person localPerson = new Person
                {
                    Name = localName,
                    Age = logalAge
                };

                if (!family.FamilyMembers.Contains(localPerson))
                {
                    family.FamilyMembers.Add(localPerson);
                }
            }
        }
    }
}

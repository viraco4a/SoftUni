using System;
using System.Linq;

namespace DefiningClasses
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Family family = new Family();

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

            var mem = family
                .FamilyMembers
                .Where(m => m.Age == family.FamilyMembers
                    .Max(e => e.Age))
                .ToList();

            Console.WriteLine($"{mem[0].Name} {mem[0].Age}");

        }
    }
}

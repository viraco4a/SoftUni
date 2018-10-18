using System;
using System.Collections.Generic;
using System.Linq;

namespace FamilyTree
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            Dictionary<string, Person> people = new Dictionary<string, Person>();
            List<string> parentage = new List<string>();
            string seeked = Console.ReadLine();
            string input = Console.ReadLine();
            while (input != "End")
            {
                if (!input.Contains('-'))
                {
                    string[] splitted = input.Split(' ');
                    string name = splitted[0] + " " + splitted[1];
                    string birthdate = splitted[2];
                    people.Add(name, new Person(name, birthdate));
                }
                else
                {
                    parentage.Add(input);
                }
                input = Console.ReadLine();
            }

            foreach (string line in parentage)
            {
                string[] splitted = line.Split(" - ");
                if (!splitted[0].Contains('/'))
                {
                    string parentName = splitted[0];
                    Person parentPerson = people
                                            .Where(s => s.Value.Name == parentName)
                                            .FirstOrDefault()
                                            .Value;
                    if (!splitted[1].Contains('/'))
                    {
                        string childName = splitted[1];
                        Person childPerson = people
                                               .Where(s => s.Value.Name == childName)
                                               .FirstOrDefault()
                                               .Value;
                        people[parentName].Childrens.Add(childPerson);
                        people[childName].Parents.Add(parentPerson);
                    }
                    else
                    {
                        string childDate = splitted[1];
                        Person childPerson = people
                                               .Where(s => s.Value.BirthDate == childDate)
                                               .FirstOrDefault()
                                               .Value;
                        people[parentName].Childrens.Add(childPerson);
                        people[childPerson.Name].Parents.Add(parentPerson);
                    }
                }
                else
                {
                    string parentDate = splitted[0];
                    Person parentPerson = people
                                            .Where(s => s.Value.BirthDate == parentDate)
                                            .FirstOrDefault()
                                            .Value;
                    if (!splitted[1].Contains('/'))
                    {
                        string childName = splitted[1];
                        Person childPerson = people
                                               .Where(s => s.Value.Name == childName)
                                               .FirstOrDefault()
                                               .Value;
                        people[parentPerson.Name].Childrens.Add(childPerson);
                        people[childName].Parents.Add(parentPerson);
                    }
                    else
                    {
                        string childDate = splitted[1];
                        Person childPerson = people
                                               .Where(s => s.Value.BirthDate == childDate)
                                               .FirstOrDefault()
                                               .Value;
                        people[parentPerson.Name].Childrens.Add(childPerson);
                        people[childPerson.Name].Parents.Add(parentPerson);
                    }
                }
            }
            string seekedPerson = "";
            if (seeked.Contains('/'))
            {
                seekedPerson = people
                                    .Where(s => s.Value.BirthDate == seeked)
                                    .FirstOrDefault()
                                    .Value
                                    .Name;
            }
            else
            {
                seekedPerson = seeked;
            }
            Console.WriteLine($"{people[seekedPerson].Name} {people[seekedPerson].BirthDate}");
            Console.WriteLine("Parents:");
            people[seekedPerson].Parents.ForEach(p =>
            {
                Console.WriteLine($"{p.Name} {p.BirthDate}");
            });
            Console.WriteLine("Children:");
            people[seekedPerson].Childrens.ForEach(c =>
            {
                Console.WriteLine($"{c.Name} {c.BirthDate}");
            });
        }
    }
}

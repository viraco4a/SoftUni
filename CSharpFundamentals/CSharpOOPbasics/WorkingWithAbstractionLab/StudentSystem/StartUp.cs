using System;
using System.Collections.Generic;

namespace StudentSystem
{
    public class StartUp
    {
        private static Dictionary<string, Student> repo = new Dictionary<string, Student>();

        static void Main()
        {
            string[] args = Console.ReadLine().Split();

            while (args[0] != "Exit")
            {
                if (args[0] == "Create")
                {
                    Create(args);
                }
                else if (args[0] == "Show")
                {
                    Show(args);
                }
                args = Console.ReadLine().Split();
            }
        }

        private static void Show(string[] args)
        {
            var name = args[1];
            if (repo.ContainsKey(name))
            {
                var student = repo[name];
                string view = $"{student.Name} is {student.Age} years old.";

                if (student.Grade >= 5.00)
                {
                    view += " Excellent student.";
                }
                else if (student.Grade < 5.00 && student.Grade >= 3.50)
                {
                    view += " Average student.";
                }
                else
                {
                    view += " Very nice person.";
                }

                Console.WriteLine(view);
            }
        }

        private static void Create(string[] args)
        {
            var name = args[1];
            var age = int.Parse(args[2]);
            var grade = double.Parse(args[3]);
            if (!repo.ContainsKey(name))
            {
                var student = new Student(name, age, grade);
                repo[name] = student;
            }
        }
    }
}

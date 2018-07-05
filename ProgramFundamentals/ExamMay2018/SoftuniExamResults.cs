using System;
using System.Collections.Generic;
using System.Linq;

namespace SoftuniExamResults
{
    class Program
    {
        private static Dictionary<string, Dictionary<string, int>> students = new Dictionary<string, Dictionary<string, int>>();
        private static Dictionary<string, int> languages = new Dictionary<string, int>();

        static void Main()
        {
            GetData();

            Console.WriteLine("Results:");
            students.OrderByDescending(s => s.Value.Values.Max())
                .ThenBy(s => s.Key)
                .ToDictionary(k => k.Key, v => v.Value)
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine($"{s.Key} | {s.Value.Values.Max()}");
                });

            Console.WriteLine("Submissions:");
            languages.OrderByDescending(s => s.Value)
                .ThenBy(s => s.Key)
                .ToDictionary(k => k.Key, v => v.Value)
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine($"{s.Key} - {s.Value}");
                });

        }

        private static void GetData()
        {
            string input = Console.ReadLine();
            while (input != "exam finished")
            {
                var splitted = input.Split(new char[] { '-' }, StringSplitOptions.RemoveEmptyEntries);
                string username = splitted[0];
                if (splitted[1] == "banned")
                {
                    if (students.ContainsKey(username))
                    {
                        students.Remove(username);
                    }
                    input = Console.ReadLine();
                    continue;
                }
                string language = splitted[1];
                int points = int.Parse(splitted[2]);

                if (!students.ContainsKey(username))
                {
                    students.Add(username, new Dictionary<string, int>());
                }
                if (!students[username].ContainsKey(language))
                {
                    students[username].Add(language, points);
                }
                else if (students[username][language] < points)
                {
                    students[username][language] = points;
                }
                if (!languages.ContainsKey(language))
                {
                    languages.Add(language, 0);
                }
                languages[language]++;

                input = Console.ReadLine();
            }

        }
    }
}
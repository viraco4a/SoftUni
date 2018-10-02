using System;
using System.Collections.Generic;
using System.Linq;

namespace Ranking
{
    class Ranking
    {
        private static Dictionary<string, SortedDictionary<string, int>> students;
        private static Dictionary<string, string> contests;
        private static string bestStudent;
        private static int max;
        static void Main(string[] args)
        {
            students = new Dictionary<string, SortedDictionary<string, int>>();

            contests = new Dictionary<string, string>();

            ReadContestData();

            ReadSubmissionData();

            PrintBest();

            students
                .OrderBy(o => o.Key)
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine(s.Key);
                    s.Value
                    .OrderByDescending(o => o.Value)
                    .ToList()
                    .ForEach(k =>
                    {
                        Console.WriteLine($"#  {k.Key} -> {k.Value}");
                    });
                });
        }

        private static void PrintBest()
        {
            Console.WriteLine($"Best candidate is {bestStudent} with total {students[bestStudent].Sum(s => s.Value)} points.");
            Console.WriteLine("Ranking:");
        }

        private static void ReadSubmissionData()
        {
            string input = Console.ReadLine();
            while (input != "end of submissions")
            {
                var splitted = input.Split("=>");
                string contest = splitted[0];
                string pass = splitted[1];
                string username = splitted[2];
                int points = int.Parse(splitted[3]);
                if (!contests.ContainsKey(contest))
                {
                    input = Console.ReadLine();
                    continue;
                }
                else if (contests[contest] != pass)
                {
                    input = Console.ReadLine();
                    continue;
                }

                if (!students.ContainsKey(username))
                {
                    students.Add(username, new SortedDictionary<string, int>());
                }

                if (!students[username].ContainsKey(contest))
                {
                    students[username].Add(contest, points);
                }
                else if (points > students[username][contest])
                {
                    students[username][contest] = points;
                }

                if (points > max)
                {
                    max = points;
                    bestStudent = username;
                }

                input = Console.ReadLine();
            }
        }

        private static void ReadContestData()
        {
            string input = Console.ReadLine();
            while (input != "end of contests")
            {
                var splitted = input.Split(':');
                if (!contests.ContainsKey(splitted[0]))
                {
                    contests.Add(splitted[0], splitted[1]);
                }

                input = Console.ReadLine();
            }
        }
    }
}
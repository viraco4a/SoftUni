using System;
using System.Collections.Generic;
using System.Linq;

namespace TheVlogger
{
    class TheVlogger
    {
        private static Dictionary<string, SortedSet<string>[]> vloggers;
        private static int max = 0;
        private static string vloggerMax;

        static void Main(string[] args)
        {
            vloggers = new Dictionary<string, SortedSet<string>[]>();
            ReadInput();
            PrintFirstLine();
            PrintTopVlogger();
            PrintVloggers();
        }

        private static void PrintVloggers()
        {
            int counter = 1;
            vloggers
                .OrderByDescending(a => a.Value[0].Count)
                .ThenBy(x => x.Value[1].Count)
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine($"{++counter}. {s.Key} : {s.Value[0].Count} followers, {s.Value[1].Count} following");
                });
        }

        private static void PrintTopVlogger()
        {
            var top = vloggers[vloggerMax];
            vloggers.Remove(vloggerMax);
            Console.WriteLine($"1. {vloggerMax} : {top[0].Count} followers, {top[1].Count} following");
            top[0].ToList().ForEach(s =>
            {
                Console.WriteLine($"*  {s}");
            });
        }

        private static void PrintFirstLine()
        {
            Console.WriteLine($"The V-Logger has a total of {vloggers.Count} vloggers in its logs.");
        }

        private static void ReadInput()
        {
            string input = Console.ReadLine();
            while (input != "Statistics")
            {
                if (input.Contains(" joined The V-Logger"))
                {
                    string vlogger = input
                        .Split(" joined The V-Logger")[0];
                    if (!vloggers.ContainsKey(vlogger))
                    {
                        vloggers.Add(vlogger, new SortedSet<string>[] {
                            new SortedSet<string>(), new SortedSet<string>()});
                    }
                }
                else
                {
                    string follower = input
                        .Split(" followed ")[0];

                    string followee = input
                        .Split(" followed ")[1];

                    if (!vloggers.ContainsKey(follower) ||
                        !vloggers.ContainsKey(followee) ||
                        follower == followee)
                    {
                        input = Console.ReadLine();
                        continue;
                    }

                    vloggers[followee][0].Add(follower);
                    vloggers[follower][1].Add(followee);

                    if (vloggers[followee][0].Count == max)
                    {
                        if (vloggers[followee][1].Count < vloggers[vloggerMax][1].Count)
                        {
                            vloggerMax = followee;
                        }
                    }
                    if (vloggers[followee][0].Count > max)
                    {
                        max = vloggers[followee][0].Count;
                        vloggerMax = followee;
                    }
                }

                input = Console.ReadLine();
            }
        }
    }
}

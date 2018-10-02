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
                        vloggers.Add(vlogger, new SortedSet<string>[](); //TODO
                    }
                }
                else
                {
                    string follower = input
                        .Split(" followed ")[0];

                    string followee = input
                        .Split(" followed ")[1];

                    if (!vloggers.ContainsKey(follower) ||
                        !vloggers.ContainsKey(followee))
                    {
                        input = Console.ReadLine();
                        continue;
                    }

                    vloggers[followee].Add(follower);

                    if (vloggers[followee].Count == max)
                    {
                        if (vloggers[followee)
                        {
                            //TODO
                        }
                    }
                    if (vloggers[followee].Count > max)
                    {
                        max = vloggers[followee].Count;
                        vloggerMax = followee;
                    }
                }

                input = Console.ReadLine();
            }
        }
    }
}

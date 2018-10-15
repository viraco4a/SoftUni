using System;
using System.Collections.Generic;
using System.Linq;

namespace Tagram
    class Tagram
    {
        private static Dictionary<string, Dictionary<string, long>> database = new Dictionary<string, Dictionary<string, long>>();
        static void Main(string[] args)
        {
            GetData();
            database
                .OrderByDescending(u => u.Value.Sum(v => v.Value))
                .ThenBy(t => t.Value.Count)
                .ToList()
                .ForEach(s =>
                {
                    Console.WriteLine(s.Key);
                    s.Value.ToList().ForEach(v =>
                    {
                        Console.WriteLine($"- {v.Key}: {v.Value}");
                    });
                });
        }

        private static void GetData()
        {
            string input = Console.ReadLine();
            while (input != "end")
            {
                if (input.Contains(" -> "))
                {
                    var line = input.Split(" -> ", StringSplitOptions.RemoveEmptyEntries);
                    string username = line[0];
                    string tag = line[1];
                    long likes = long.Parse(line[2]);

                    if (!database.ContainsKey(username))
                    {
                        database.Add(username, new Dictionary<string, long>());
                    }
                    if (!database[username].ContainsKey(tag))
                    {
                        database[username].Add(tag, 0);
                    }

                    database[username][tag] += likes;
                }
                else if (input.Contains("ban"))
                {
                    var line = input.Split(" ", StringSplitOptions.RemoveEmptyEntries);
                    string userToRemove = line[1];
                    if (database.ContainsKey(userToRemove))
                    {
                        database.Remove(userToRemove);
                    }
                }

                input = Console.ReadLine();
            }
        }
    }
}

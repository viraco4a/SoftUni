using System;
using System.Collections.Generic;
using System.Linq;

namespace P05_GreedyTimes
{

    public class GreedyTimes
    {
        private static Dictionary<string, Dictionary<string, long>> bag;
        static void Main(string[] args)
        {
            bag = new Dictionary<string, Dictionary<string, long>>();

            long bagCapacity = long.Parse(Console.ReadLine());
            string[] input = Console.ReadLine()
                .Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries);

            long gold = 0;
            long gems = 0;
            long cash = 0;

            for (int i = 0; i < input.Length; i += 2)
            {
                string name = input[i];
                long amount = long.Parse(input[i + 1]);

                string type = GetType(name);

                if (type == "")
                {
                    continue;
                }
                else if (BagSmallerThanAmount(bagCapacity, amount))
                {
                    continue;
                }

                switch (type)
                {
                    case "Gem":
                        if (!bag.ContainsKey(type))
                        {
                            if (bag.ContainsKey("Gold"))
                            {
                                if (amount > bag["Gold"].Values.Sum())
                                {
                                    continue;
                                }
                            }
                            else
                            {
                                continue;
                            }
                        }
                        else if (AreGemsMoreThanGold(amount, type, "Gold"))
                        {
                            continue;
                        }
                        break;
                    case "Cash":
                        if (!bag.ContainsKey(type))
                        {
                            if (bag.ContainsKey("Gem"))
                            {
                                if (amount > bag["Gem"].Values.Sum())
                                {
                                    continue;
                                }
                            }
                            else
                            {
                                continue;
                            }
                        }
                        else if (AreGemsMoreThanGold(amount, type, "Gem"))
                        {
                            continue;
                        }
                        break;
                }

                if (!bag.ContainsKey(type))
                {
                    bag[type] = new Dictionary<string, long>();
                }

                if (!bag[type].ContainsKey(name))
                {
                    bag[type][name] = 0;
                }

                bag[type][name] += amount;

                if (type == "Gold")
                {
                    gold += amount;
                }
                else if (type == "Gem")
                {
                    gems += amount;
                }
                else if (type == "Cash")
                {
                    cash += amount;
                }
            }

            Print();
        }

        private static void Print()
        {
            foreach (var x in bag)
            {
                Console.WriteLine($"<{x.Key}> ${x.Value.Values.Sum()}");
                foreach (var item2 in x.Value.OrderByDescending(y => y.Key).ThenBy(y => y.Value))
                {
                    Console.WriteLine($"##{item2.Key} - {item2.Value}");
                }
            }
        }

        private static bool AreGemsMoreThanGold(long amount, string type, string typeOfProfit)
        {
            return bag[type].Values.Sum() + amount > bag[typeOfProfit].Values.Sum();
        }

        private static string GetType(string name)
        {
            string type = string.Empty;

            if (name.Length == 3)
            {
                type = "Cash";
            }
            else if (name.ToLower().EndsWith("gem"))
            {
                type = "Gem";
            }
            else if (name.ToLower() == "gold")
            {
                type = "Gold";
            }

            return type;
        }

        private static bool BagSmallerThanAmount(long bagCapacity, long amount)
        {
            return bagCapacity < bag.Values.Select(x => x.Values.Sum()).Sum() + amount;
        }
    }
}
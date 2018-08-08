using System;
using System.Collections.Generic;
using System.Linq;

namespace Snowmen
{
    class Program
    {
        private static List<int> sequence;

        static void Main()
        {
            sequence = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList();

            while (sequence.Count > 1)
            {
                FightThrough();
                sequence.RemoveAll(s => s == -1);
            }

        }

        private static void FightThrough()
        {
            for (int i = 0; i < sequence.Count; i++)
            {
                if (sequence[i] == -1)
                {
                    continue;
                }
                if (sequence.Where(s => s != -1).Count() == 1)
                {
                    return;
                }
                int attacker = i;
                int target = sequence[i] >= sequence.Count ? sequence[i] % sequence.Count : sequence[i];

                int diff = Math.Abs(attacker - target);
                if (diff != 0)
                {
                    if (diff % 2 == 0)
                    {
                        Console.WriteLine($"{attacker} x {target} -> {attacker} wins");
                        sequence[target] = -1;
                    }
                    else
                    {
                        Console.WriteLine($"{attacker} x {target} -> {target} wins");
                        sequence[attacker] = -1;
                    }
                }
                else
                {
                    Console.WriteLine($"{attacker} performed harakiri");
                    sequence[attacker] = -1;
                }
            }
        }
    }
}

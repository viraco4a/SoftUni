using System;
using System.Collections.Generic;
using System.Linq;

namespace TruckTour
{
    class TruckTour
    {

        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            Queue<int[]> pumps = new Queue<int[]>();

            for (int i = 0; i < N; i++)
            {
                int[] tokens = Console.ReadLine()
                    .Split()
                    .Select(int.Parse)
                    .ToArray();
                pumps.Enqueue(tokens);
            }

            int index = 0;

            while (true)
            {
                int totalFuel = 0;

                foreach (var pump in pumps)
                {
                    int fuel = pump[0];
                    int distance = pump[1];

                    totalFuel += fuel - distance;
                    if (totalFuel < 0)
                    {
                        index++;
                        int[] currentPump = pumps.Dequeue();
                        pumps.Enqueue(currentPump);
                        break;
                    }
                }
                if (totalFuel >= 0)
                {
                    break;
                }
            }
            Console.WriteLine(index);
        }
    }
}

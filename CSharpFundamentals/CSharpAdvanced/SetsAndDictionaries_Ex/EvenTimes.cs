﻿using System;
using System.Collections.Generic;

namespace EvenTimes
{
    class EvenTimes
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            var numbers = new Dictionary<int, int>();
            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                if (!numbers.ContainsKey(num))
                {
                    numbers.Add(num, 0);
                }
                numbers[num]++;
            }

            foreach (var item in numbers)
            {
                if (item.Value % 2 == 0)
                {
                    Console.WriteLine(item.Key);
                    break;
                }
            }
        }
    }
}

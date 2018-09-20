using System;
using System.Collections.Generic;

namespace HotPotato
{
    class HotPotato
    {
        static void Main(string[] args)
        {
            string[] splitted = Console.ReadLine().Split();
            int index = int.Parse(Console.ReadLine());
            Queue<string> queue = new Queue<string>(splitted);
            while (queue.Count > 1)
            {
                for (int i = 1; i < index; i++)
                {
                    queue.Enqueue(queue.Dequeue());
                }
                Console.WriteLine($"Removed {queue.Dequeue()}");
            }
            Console.WriteLine($"Last is {queue.Dequeue()}");
        }
    }
}

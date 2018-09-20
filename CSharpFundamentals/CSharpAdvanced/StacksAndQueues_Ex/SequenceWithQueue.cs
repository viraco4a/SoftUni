using System;
using System.Collections.Generic;
using System.Text;

namespace SequenceWithQueue
{
    class SequenceWithQueue
    {
        static void Main(string[] args)
        {
            long N = long.Parse(Console.ReadLine());
            Queue<long> queue = new Queue<long>();
            queue.Enqueue(N);
            StringBuilder sb = new StringBuilder();            
            int counter = 1;
            while (counter <= 50)
            {
                long S1 = queue.Dequeue();
                sb.Append(S1 + " ");
                queue.Enqueue(S1 + 1);
                queue.Enqueue(2 * S1 + 1);
                queue.Enqueue(S1 + 2);
                counter++;
            }
            Console.WriteLine(sb.ToString());
        }
    }
}

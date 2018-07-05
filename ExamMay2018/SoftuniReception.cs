using System;

namespace SoftuniReception
{
    class Program
    {
        static void Main()
        {
            int first = int.Parse(Console.ReadLine());
            int second = int.Parse(Console.ReadLine());
            int third = int.Parse(Console.ReadLine());
            int studentCount = int.Parse(Console.ReadLine());
            if (studentCount == 0)
            {
                Console.WriteLine($"Time needed: {0}h.");
                return;
            }
            int total = first + second + third;
            int time = 0;
            for (int i = 1; ; i++)
            {
                time++;
                if (i % 4 != 0)
                {
                    studentCount -= total;
                }
                if (studentCount <= 0)
                {
                    break;
                }
            }
            Console.WriteLine($"Time needed: {time}h.");
        }
    }
}

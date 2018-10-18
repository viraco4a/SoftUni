using System;
using System.Linq;
using System.Collections.Generic;

namespace RectangleIntersection
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            int[] operations = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
            Dictionary<string, Rectangle> rectangles = new Dictionary<string, Rectangle>();

            for (int i = 0; i < operations[0]; i++)
            {
                string[] input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                string id = input[0];
                int width = int.Parse(input[1]);
                int height = int.Parse(input[2]);
                double x = double.Parse(input[3]);
                double y = double.Parse(input[4]);
                Rectangle rectangle = new Rectangle(id, width, height, x, y);
                rectangles.Add(id, rectangle);
            }

            for (int i = 0; i < operations[1]; i++)
            {
                string[] input = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);

                if (rectangles[input[0]].IsInside(rectangles[input[1]]))
                {
                    Console.WriteLine("true");
                }
                else
                {
                    Console.WriteLine("false");
                }
            }
        }
    }
}

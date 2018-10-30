using System;

namespace PointInRectangle
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            string[] data = Console.ReadLine().Split();
            Rectangle rectangle = new Rectangle()
            {
                TopLeft = new Point()
                {
                    X = int.Parse(data[0]),
                    Y = int.Parse(data[1])
                },
                BottomRight = new Point()
                {
                    X = int.Parse(data[2]),
                    Y = int.Parse(data[3])
                }
            };

            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                data = Console.ReadLine().Split();
                Point point = new Point()
                {
                    X = int.Parse(data[0]),
                    Y = int.Parse(data[1])
                };
                Console.WriteLine(rectangle.Contains(point));
            }
        }
    }
}

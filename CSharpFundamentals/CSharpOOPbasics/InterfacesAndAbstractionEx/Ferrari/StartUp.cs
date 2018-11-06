using System;

namespace Ferrari
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            string driver = Console.ReadLine();
            ICar ferrary = new Ferrari(driver);
            Console.WriteLine(ferrary);
        }
    }
}

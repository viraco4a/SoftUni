using System;
using System.Linq;

namespace DefiningClasses
{
    public class StartUp
    {
        public static void Main(string[] args)
        {
            string first = Console.ReadLine();
            string second = Console.ReadLine();
            DateModifier dateModifier = new DateModifier();
            Console.WriteLine(dateModifier.CalcDifference(first, second));
        }
    }
}

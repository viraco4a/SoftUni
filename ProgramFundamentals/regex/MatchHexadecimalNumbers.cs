using System;
using System.Text.RegularExpressions;

namespace MatchHexadecimalNumbers
{
    class Program
    {
        static void Main()
        {
            string pattern = @"\b(?:0x)?[0-9A-F]+\b";

            MatchCollection matches = Regex.Matches(Console.ReadLine(), pattern);

            foreach (Match item in matches)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();
        }
    }
}

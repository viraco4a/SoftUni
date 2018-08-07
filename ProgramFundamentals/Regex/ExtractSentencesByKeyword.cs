using System;
using System.Text.RegularExpressions;

namespace ExtractSentencesByKeyword
{
    class Program
    {
        static void Main()
        {
            string keyWord = Console.ReadLine();
            string pattern = $@"(^|(?<=\s)){keyWord}($|(?=\s))";
            var input = Console.ReadLine().Split(new char[] { '!', '.', '?' }, StringSplitOptions.RemoveEmptyEntries);
            foreach (var sentence in input)
            {
                Match match = Regex.Match(sentence, pattern);
                if (match.Success)
                {
                    Console.WriteLine(sentence.Trim());
                }
            }
        }
    }
}

using System;
using System.Text.RegularExpressions;
using System.Text;
using System.IO;

namespace UseYourChainsBuddy
{
    class Program
    {
        private static string pattern = @"<p>(.*?)<\/p>";
        private static string patternSpaces = @"[^a-z0-9]+";
        private static StringBuilder sb = new StringBuilder();
        
        static void Main()
        {
            Console.SetIn(new StreamReader(Console.OpenStandardInput(8192)));
            string input = Console.ReadLine();
            string firstIteration = FirstIterationTags(input);
            string secondIteration = SecondIterationSpaces(firstIteration);
            string thirdIteration = ThirdIterationDecrypt(secondIteration);
            Console.WriteLine(thirdIteration);
        }

        private static string ThirdIterationDecrypt(string input)
        {
            for (int i = 0; i < input.Length; i++)
            {
                if ((int)input[i] > 96 && (int)input[i] < 123)
                {
                    if ((int)input[i] <= 109)
                    {
                        char local = (char)((int)input[i] + 13);
                        sb.Append(local.ToString());
                    }
                    else
                    {
                        char local = (char)((int)input[i] - 13);
                        sb.Append(local.ToString());
                    }
                }
                else
                {
                    sb.Append(input[i].ToString());
                }
            }
            string result = sb.ToString();
            sb.Clear();
            return result;
        }

        private static string SecondIterationSpaces(string input)
        {
            Regex regex = new Regex(patternSpaces);
            string secondIteration = regex.Replace(input, " ");
            return secondIteration;
        }

        private static string FirstIterationTags(string input)
        {
            MatchCollection matches = Regex.Matches(input, pattern);
            foreach (Match match in matches)
            {
                sb.Append(match.Groups[1].Value);
            }
            string first = sb.ToString();
            sb.Clear();
            return first;
        }
    }
}

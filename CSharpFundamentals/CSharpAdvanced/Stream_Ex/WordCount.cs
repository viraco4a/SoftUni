using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace WordCount
{
    class WordCount
    {
        private static new Dictionary<string, int> words = new Dictionary<string, int>();
        static void Main(string[] args)
        {
            string path = "../../../";
            string text = "text.txt";
            string patternFile = Path.Combine(path, "words.txt");
            string output = Path.Combine(path, "results.txt");
            string regexPattern = @"[A-Za-z]+";

            path = Path.Combine(path, text);

            using (StreamReader reader = new StreamReader(patternFile))
            {
                ReadWords(reader);
            }

            using (StreamReader reader = new StreamReader(path))
            {
                string line = reader.ReadLine();
                while (line != null)
                {
                    Regex regex = new Regex(regexPattern);
                    foreach (Match item in regex.Matches(line))
                    {
                        if (words.ContainsKey(item.Value.ToLower()))
                        {
                            words[item.Value.ToLower()]++;
                        }
                    }
                    line = reader.ReadLine();
                }
            }

            using (StreamWriter writer = new StreamWriter(output))
            {
                foreach (var word in words.OrderByDescending(s => s.Value))
                {
                    writer.WriteLine($"{word.Key} - {word.Value}");
                }
            }
        }

        private static void ReadWords(StreamReader pattern)
        {
            string line = pattern.ReadLine();
            while (line != null)
            {
                if (!words.ContainsKey(line.ToLower()))
                {
                    words.Add(line.ToLower(), 0);
                }
                line = pattern.ReadLine();
            }
        }
    }
}

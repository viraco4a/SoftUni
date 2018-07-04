using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;
using System.Linq;

namespace QueryMess
{
    class Line
    {
        public string Name { get; set; }
        public List<string> ListOfStrings { get; set; }

        public void AddElement(string element)
        {
            this.ListOfStrings.Add(element);
        }
    }

    class Program
    {
        private static string pattern = @"^([^=&]+)=([^=&]+)$";
        
        static void Main()
        {
            string input = Console.ReadLine();

            while (input != "END")
            {
                var splitted = input.Split(new char[] { '&', '?' }, StringSplitOptions.RemoveEmptyEntries);
                splitted = ReplaceSpace(splitted);
                PrintKVPs(splitted);
                input = Console.ReadLine();
            }
        }

        private static string[] ReplaceSpace(string[] line)
        {
            var list = new List<string>();
            foreach (var item in line.ToArray())
            {
                var splitted = item.Split(new string[] { "+", "%20" }, StringSplitOptions.RemoveEmptyEntries);
                string newItem = string.Join(" ", splitted.Where(s => s != string.Empty));
                list.Add(newItem.Trim());
            }

            return list.ToArray();
        }

        private static void PrintKVPs(string[] line)
        {
            List<Line> collection = new List<Line>();
            foreach (var item in line)
            {
                Match match = Regex.Match(item, pattern);
                if (!match.Success)
                {
                    continue;
                }
                string key = match.Groups[1].Value.Trim();
                string value = match.Groups[2].Value.Trim();

                if (!collection.Select(s => s.Name).Contains(key))
                {
                    collection.Add(new Line
                    {
                        Name = key,
                        ListOfStrings = new List<string>() { value }
                    });
                }
                else
                {
                    collection
                        .Where(s => s.Name == key)
                        .FirstOrDefault()
                        .AddElement(value);
                }
            }
            foreach (var element in collection)
            {
                Console.Write(element.Name + "=[" + string.Join(", ", element.ListOfStrings) + "]");
            }
            Console.WriteLine();
        }
    }
}

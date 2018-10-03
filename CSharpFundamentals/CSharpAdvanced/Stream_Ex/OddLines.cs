using System;
using System.IO;

namespace OddLines
{
    class OddLines
    {
        static void Main(string[] args)
        {
            string path = "../../../";
            string fileName = "text.txt";

            path = Path.Combine(path, fileName);

            using (StreamReader reader = new StreamReader(path))
            {
                int i = 0;
                string line = reader.ReadLine();

                while (line != null)
                {
                    if (i % 2 != 0)
                    {
                        Console.WriteLine(line);
                    }
                    i++;
                    line = reader.ReadLine();
                }
            }
        }
    }
}

using System;
using System.IO;

namespace LineNumbers
{
    class LineNumbers
    {
        static void Main(string[] args)
        {
            string path = "../../../";
            string fileName = "text.txt";
            string output = Path.Combine(path, "output.txt");

            path = Path.Combine(path, fileName);

            using (StreamReader reader = new StreamReader(path))
            {
                using (StreamWriter writer = new StreamWriter(output))
                {
                    int i = 0;
                    string line = reader.ReadLine();
                    while (line != null)
                    {
                        writer.WriteLine(($"Line {++i}: {line}"));
                        line = reader.ReadLine();
                    }
                }
            }
        }
    }
}

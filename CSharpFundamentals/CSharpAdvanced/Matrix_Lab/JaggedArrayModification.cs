using System;
using System.Linq;

namespace JaggedArrayModification
{
    class JaggedArrayModification
    {
        private static int[][] matrix;
        static void Main(string[] args)
        {
            ReadMatrix();
            string command = Console.ReadLine();
            while (command != "END")
            {
                string[] splitted = command
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries);
                if (isValid(splitted))
                {
                    int first = int.Parse(splitted[1]);
                    int second = int.Parse(splitted[2]);
                    int newValue = int.Parse(splitted[3]);

                    if (splitted[0] == "Add")
                    {
                        matrix[first][second] += newValue;
                    }
                    else
                    {
                        matrix[first][second] -= newValue;
                    }
                }
                else
                {
                    Console.WriteLine("Invalid coordinates");
                }
                command = Console.ReadLine();
            }

            for (int row = 0; row < matrix.Length; row++)
            {
                Console.WriteLine(string.Join(" ", matrix[row]));
            }
        }

        private static bool isValid(string[] splitted)
        {
            int first = int.Parse(splitted[1]);
            int second = int.Parse(splitted[2]);
            if (first < 0 || second < 0 || first > matrix.Length - 1
                || second > matrix[0].Length)
            {
                return false;
            }
            return true;
        }

        private static void ReadMatrix()
        {
            int rows = int.Parse(Console.ReadLine());
            matrix = new int[rows][];
            for (int row = 0; row < rows; row++)
            {
                int[] line = Console.ReadLine()
                    .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                    .Select(int.Parse)
                    .ToArray();
                matrix[row] = line;
            }
        }
    }
}

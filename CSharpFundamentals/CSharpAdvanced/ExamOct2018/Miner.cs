using System;

namespace Miner
{
    class Miner
    {
        private static string[,] matrix;
        private static int coilLeft = 0;
        private static int collectedCoil = 0;
        private static int totalCoil = 0;
        private static int n = 0;
        private static int indexRowCur = 0;
        private static int indexColCur = 0;
        private static bool mustEnd = false;
        static void Main(string[] args)
        {
            n = int.Parse(Console.ReadLine());
            string[] commands = Console.ReadLine()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries);
            ReadMatrix();
            foreach (var command in commands)
            {
                if (mustEnd)
                {
                    return;
                }
                switch (command)
                {
                    case "up": Up(); break;
                    case "down": Down(); break;
                    case "right": Right(); break;
                    case "left": Left(); break;
                }
                if (mustEnd)
                {
                    return;
                }
            }
            Console.WriteLine($"{coilLeft} coals left. ({indexRowCur}, {indexColCur})");
        }


        private static void Up()
        {
            if (IsValid(indexRowCur - 1, indexColCur))
            {
                Consume(indexRowCur - 1, indexColCur);
            }
        }

        private static void Down()
        {
            if (IsValid(indexRowCur + 1, indexColCur))
            {
                Consume(indexRowCur + 1, indexColCur);
            }
        }

        private static void Right()
        {
            if (IsValid(indexRowCur, indexColCur + 1))
            {
                Consume(indexRowCur, indexColCur + 1);
            }
        }

        private static void Left()
        {
            if (IsValid(indexRowCur, indexColCur - 1))
            {
                Consume(indexRowCur, indexColCur - 1);
            }
        }

        private static void Consume(int row, int col)
        {
            indexRowCur = row;
            indexColCur = col;
            if (matrix[row, col] == "e")
            {
                mustEnd = true;
                Console.WriteLine($"Game over! ({indexRowCur}, {indexColCur})");
            }
            else if (matrix[row, col] == "c")
            {
                collectedCoil++;
                coilLeft--;
                matrix[row, col] = "*";
                if (collectedCoil == totalCoil)
                {
                    mustEnd = true;
                    Console.WriteLine($"You collected all coals! ({indexRowCur}, {indexColCur})");
                }
            }
        }

        private static bool IsValid(int row, int col)
        {
            return row >= 0 && row < n && col >= 0 && col < n;
        }

        private static void ReadMatrix()
        {
            matrix = new string[n, n];

            for (int row = 0; row < n; row++)
            {
                string[] line = Console.ReadLine().Split(' ');
                for (int col = 0; col < n; col++)
                {
                    matrix[row, col] = line[col];
                    if (line[col] == "s")
                    {
                        indexRowCur = row;
                        indexColCur = col;
                    }
                    else if (line[col] == "c")
                    {
                        coilLeft++;
                        totalCoil++;
                    }
                }
            }
        }
    }
}

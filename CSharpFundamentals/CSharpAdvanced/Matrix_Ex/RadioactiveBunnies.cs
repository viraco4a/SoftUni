using System;
using System.Collections.Generic;
using System.Linq;

namespace RadioactiveBunnies
{
    class RadioactiveBunnies
    {
        private static char[,] lair;
        private static int pRow = 0;
        private static int pCol = 0;
        private static int timer = 0;
        private static bool dead = false;
        private static bool escape = false;

        static void Main(string[] args)
        {
            ReadLairData();
            string commands = Console.ReadLine();
            while (true)
            {
                if (dead)
                {
                    PrintDeath();
                    return;
                }
                if (escape)
                {
                    return;
                }
                SpreadBunnies();
                if (dead)
                {
                    MovePlayer(commands);
                    PrintDeath();
                    return;
                }
                MovePlayer(commands);
                timer++;
            }
        }

        private static void PrintDeath()
        {
            for (int r = 0; r < lair.GetLength(0); r++)
            {
                for (int c = 0; c < lair.GetLength(1); c++)
                {
                    Console.Write(lair[r, c]);
                }
                Console.WriteLine();
            }
            Console.WriteLine($"dead: {pRow} {pCol}");
        }

        private static void MovePlayer(string commands)
        {
            char command = commands[timer];
            if (!dead)
            {
                lair[pRow, pCol] = '.';
            }
            switch (command)
            {
                case 'U':
                    pRow--;
                    if (pRow < 0)
                    {
                        if (dead)
                        {
                            pRow = 0;
                            break;
                        }
                        Win(pRow + 1, pCol);
                        escape = true;
                        break;
                    }
                    if (lair[pRow, pCol] == 'B')
                    {
                        dead = true;
                        break;
                    }
                    break;
                case 'D':
                    pRow++;
                    if (pRow > lair.GetLength(0))
                    {
                        if (dead)
                        {
                            pRow = lair.GetLength(0) - 1;
                            break;
                        }
                        Win(pRow - 1, pCol);
                        escape = true;
                        break;
                    }
                    if (lair[pRow, pCol] == 'B')
                    {
                        dead = true;
                        break;
                    }
                    break;
                case 'L':
                    pCol--;
                    if (pCol < 0)
                    {
                        if (dead)
                        {
                            pCol = 0;
                            break;
                        }
                        Win(pRow, pCol + 1);
                        escape = true;
                        break;
                    }
                    if (lair[pRow, pCol] == 'B')
                    {
                        dead = true;
                        break;
                    }

                    break;
                case 'R':
                    pCol++;
                    if (pCol > lair.GetLength(1))
                    {
                        if (dead)
                        {
                            pCol = lair.GetLength(1) - 1;
                            break;
                        }
                        Win(pRow, pCol - 1);
                        escape = true;
                        break;
                    }
                    if (lair[pRow, pCol] == 'B')
                    {
                        dead = true;
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (dead || escape)
            {
                return;
            }
            lair[pRow, pCol] = 'P';
        }

        private static void Win(int row, int col)
        {
            for (int r = 0; r < lair.GetLength(0); r++)
            {
                for (int c = 0; c < lair.GetLength(1); c++)
                {
                    Console.Write(lair[r, c]);
                }
                Console.WriteLine();
            }
            Console.WriteLine($"won: {row} {col}");
        }

        private static void SpreadBunnies()
        {
            Stack<int[]> bunnies = new Stack<int[]>();
            for (int row = 0; row < lair.GetLength(0); row++)
            {
                for (int col = 0; col < lair.GetLength(1); col++)
                {
                    if (lair[row, col] == 'B')
                    {
                        bunnies.Push(new int[] { row + 1, col });
                        bunnies.Push(new int[] { row - 1, col });
                        bunnies.Push(new int[] { row, col - 1 });
                        bunnies.Push(new int[] { row, col + 1 });
                    }
                }
            }
            while (bunnies.Count > 0)
            {
                int[] currentBunny = bunnies.Pop();
                if (IsInsideLair(currentBunny))
                {
                    lair[currentBunny[0], currentBunny[1]] = 'B';
                }
            }
            if(lair[pRow, pCol] == 'B')
            {
                dead = true;
            }
        }

        private static bool IsInsideLair(int[] cell)
        {
            return cell[0] >= 0 && cell[0] < lair.GetLength(0)
                && cell[1] >= 0 && cell[1] < lair.GetLength(1);
        }

        private static void ReadLairData()
        {
            int[] tokens = ReadLine();
            int rows = tokens[0];
            int cols = tokens[1];
            lair = new char[rows, cols];
            for (int row = 0; row < rows; row++)
            {
                char[] line = Console.ReadLine().ToUpper().ToCharArray();
                for (int col = 0; col < cols; col++)
                {
                    lair[row, col] = line[col];
                    if (line[col] == 'P')
                    {
                        pRow = row;
                        pCol = col;
                    }
                }
            }
        }

        private static int[] ReadLine()
        {
            return Console.ReadLine()
                .ToUpper()
                .Split(' ', StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse)
                .ToArray();
        }

    }
}

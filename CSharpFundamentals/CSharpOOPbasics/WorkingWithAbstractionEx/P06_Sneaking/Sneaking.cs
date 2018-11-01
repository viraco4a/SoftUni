using System;

namespace P06_Sneaking
{
    class Sneaking
    {
        static char[][] room;
        static void Main()
        {
            GetRoomLayout();

            char[] moves = Console.ReadLine().ToCharArray();

            int[] samPosition = GetSamPosition();

            for (int i = 0; i < moves.Length; i++)
            {
                MoveEnemies();

                int[] getEnemy = new int[2];

                KillEnemy(samPosition, getEnemy);

                if (LookRight(samPosition, getEnemy))
                {
                    ApplyDeath(samPosition);
                }
                else if (LookLeft(samPosition, getEnemy))
                {
                    ApplyDeath(samPosition);
                }

                MoveSam(moves, samPosition, i);

                KillEnemy(samPosition, getEnemy);

                PrintWin(samPosition, getEnemy);
            }
        }

        private static void PrintWin(int[] samPosition, int[] getEnemy)
        {
            if (room[getEnemy[0]][getEnemy[1]] == 'N' && samPosition[0] == getEnemy[0])
            {
                room[getEnemy[0]][getEnemy[1]] = 'X';
                Console.WriteLine("Nikoladze killed!");
                for (int row = 0; row < room.Length; row++)
                {
                    for (int col = 0; col < room[row].Length; col++)
                    {
                        Console.Write(room[row][col]);
                    }
                    Console.WriteLine();
                }
                Environment.Exit(0);
            }
        }

        private static void KillEnemy(int[] samPosition, int[] getEnemy)
        {
            for (int j = 0; j < room[samPosition[0]].Length; j++)
            {
                if (room[samPosition[0]][j] != '.' && room[samPosition[0]][j] != 'S')
                {
                    getEnemy[0] = samPosition[0];
                    getEnemy[1] = j;
                }
            }
        }

        private static void MoveSam(char[] moves, int[] samPosition, int i)
        {
            room[samPosition[0]][samPosition[1]] = '.';
            switch (moves[i])
            {
                case 'U':
                    samPosition[0]--;
                    break;
                case 'D':
                    samPosition[0]++;
                    break;
                case 'L':
                    samPosition[1]--;
                    break;
                case 'R':
                    samPosition[1]++;
                    break;
                default:
                    break;
            }
            room[samPosition[0]][samPosition[1]] = 'S';
        }

        private static void ApplyDeath(int[] samPosition)
        {
            room[samPosition[0]][samPosition[1]] = 'X';
            Console.WriteLine($"Sam died at {samPosition[0]}, {samPosition[1]}");
            for (int row = 0; row < room.Length; row++)
            {
                for (int col = 0; col < room[row].Length; col++)
                {
                    Console.Write(room[row][col]);
                }
                Console.WriteLine();
            }
            Environment.Exit(0);
        }

        private static bool LookLeft(int[] samPosition, int[] getEnemy)
        {
            return getEnemy[1] < samPosition[1] &&
                                room[getEnemy[0]][getEnemy[1]] == 'b' &&
                                getEnemy[0] == samPosition[0];
        }

        private static bool LookRight(int[] samPosition, int[] getEnemy)
        {
            return samPosition[1] < getEnemy[1] &&
                                room[getEnemy[0]][getEnemy[1]] == 'd' &&
                                getEnemy[0] == samPosition[0];
        }

        private static void MoveEnemies()
        {
            for (int row = 0; row < room.Length; row++)
            {
                for (int col = 0; col < room[row].Length; col++)
                {
                    if (room[row][col] == 'b')
                    {
                        if (IsValid(row, col, 1))
                        {
                            room[row][col] = '.';
                            room[row][col + 1] = 'b';
                            col++;
                        }
                        else
                        {
                            room[row][col] = 'd';
                        }
                    }
                    else if (room[row][col] == 'd')
                    {
                        if (IsValid(row, col, -1))
                        {
                            room[row][col] = '.';
                            room[row][col - 1] = 'd';
                        }
                        else
                        {
                            room[row][col] = 'b';
                        }
                    }
                }
            }
        }

        private static bool IsValid(int row, int col, int index)
        {
            return IsValidRow(row) &&
                col + index >= 0 && 
                col + index < room[row].Length;
        }

        private static bool IsValidRow(int row)
        {
            return row >= 0 && row < room.Length;
        }

        private static int[] GetSamPosition()
        {
            int[] samPosition = new int[2];
            for (int row = 0; row < room.Length; row++)
            {
                for (int col = 0; col < room[row].Length; col++)
                {
                    if (room[row][col] == 'S')
                    {
                        samPosition[0] = row;
                        samPosition[1] = col;
                    }
                }
            }

            return samPosition;
        }

        private static void GetRoomLayout()
        {
            int n = int.Parse(Console.ReadLine());
            room = new char[n][];

            for (int row = 0; row < n; row++)
            {
                var input = Console.ReadLine().ToCharArray();
                room[row] = new char[input.Length];
                for (int col = 0; col < input.Length; col++)
                {
                    room[row][col] = input[col];
                }
            }
        }
    }
}

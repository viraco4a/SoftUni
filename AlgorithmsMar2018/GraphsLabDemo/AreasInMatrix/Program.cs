using System;
using System.Collections.Generic;
using System.Linq;

namespace AreasInMatrix
{
    class Program
    {

        private static List<char>[,] graph;
        private static bool[,] visited;
        private static char[,] matrix;
        private static Dictionary<char, int> result;

        static void Main()
        {
            ReadInput();
            PopulateGraph();
            visited = new bool[matrix.GetLength(0), matrix.GetLength(1)];
            result = new Dictionary<char, int>();
            for (int row = 0; row < visited.GetLength(0); row++)
            {
                for (int col = 0; col < visited.GetLength(1); col++)
                {
                    if (visited[row, col])
                    {
                        continue;
                    }
                    DFS(row, col, matrix[row, col]);
                    result[matrix[row, col]]++;
                }
            }
            Console.WriteLine($"Areas: {result.Sum(s => s.Value)}");
            foreach (var kvp in result.OrderBy(s => s.Key))
            {
                Console.WriteLine($"Letter '{kvp.Key}' -> {kvp.Value}");
            }
        }

        private static void DFS(int row, int col, char symbol)
        {
            if (row < 0 || col < 0 || row > matrix.GetLength(0) - 1 || col > matrix.GetLength(1) - 1)
            {
                return;
            }
            if (!visited[row, col])
            {
                var currentNodeChar = matrix[row, col];
                if (currentNodeChar != symbol)
                {
                    return;
                }
                visited[row, col] = true;
                if (!result.ContainsKey(currentNodeChar))
                {
                    result.Add(currentNodeChar, 0);
                }
                for (int i = 0; i < graph[row, col].Count; i++)
                {
                    if (graph[row, col][i] == currentNodeChar)
                    {
                        DFS(row, col + 1, currentNodeChar);
                        DFS(row + 1, col, currentNodeChar);
                        DFS(row, col - 1, currentNodeChar);
                        DFS(row - 1, col, currentNodeChar);
                    }
                }
            }
        }

        private static void PopulateGraph()
        {
            graph = new List<char>[matrix.GetLength(0), matrix.GetLength(1)];

            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    if (row == 0)
                    {
                        if (col == 0)
                        {
                            graph[row, col] = new List<char>()
                            {
                                matrix[row + 1, col],
                                matrix[row, col + 1]
                            };
                            continue;
                        }
                        if (col == matrix.GetLength(1) - 1)
                        {
                            graph[row, col] = new List<char>()
                            {
                                matrix[row + 1, col],
                                matrix[row, col - 1]
                            };
                            continue;
                        }
                        graph[row, col] = new List<char>()
                        {
                            matrix[row, col - 1],
                            matrix[row + 1, col],
                            matrix[row, col + 1]
                        };
                        continue;
                    }
                    if (row == matrix.GetLength(0) - 1)
                    {
                        if (col == 0)
                        {
                            graph[row, col] = new List<char>()
                            {
                                matrix[row - 1, col],
                                matrix[row, col + 1]
                            };
                            continue;
                        }
                        if (col == matrix.GetLength(1) - 1)
                        {
                            graph[row, col] = new List<char>()
                            {
                                matrix[row - 1, col],
                                matrix[row, col - 1]
                            };
                            continue;
                        }
                        graph[row, col] = new List<char>()
                        {
                            matrix[row, col - 1],
                            matrix[row - 1, col],
                            matrix[row, col + 1]
                        };
                        continue;
                    }
                    if (col == 0)
                    {
                        graph[row, col] = new List<char>()
                        {
                            matrix[row - 1, col],
                            matrix[row + 1, col],
                            matrix[row, col + 1]
                        };
                        continue;
                    }
                    if (col == matrix.GetLength(1) - 1)
                    {
                        graph[row, col] = new List<char>()
                        {
                            matrix[row - 1, col],
                            matrix[row + 1, col],
                            matrix[row, col - 1]
                        };
                        continue;
                    }
                    graph[row, col] = new List<char>()
                    {
                        matrix[row - 1, col],
                        matrix[row, col - 1],
                        matrix[row + 1, col],
                        matrix[row, col + 1]
                    };
                }
            }
        }

        private static void ReadInput()
        {
            int rows = int.Parse(Console.ReadLine());
            var input = Console.ReadLine().ToCharArray();
            int cols = input.Length;
            matrix = new char[rows, cols];
            for (int row = 0; row < rows; row++)
            {
                for (int col = 0; col < cols; col++)
                {
                    matrix[row, col] = input[col];
                }
                if (row == rows - 1)
                {
                    continue;
                }
                input = Console.ReadLine().ToCharArray();
            }
        }

    }
}

using System;
using System.Collections.Generic;

namespace RenewalPractice
{
    class Edge : IComparable<Edge>
    {
        public Edge(int first, int second, int cost)
        {
            this.First = first;
            this.Second = second;
            this.Cost = cost;
        }
        public int First;
        public int Second;
        public int Cost;

        public int CompareTo(Edge other)
        {
            return this.Cost - other.Cost;
        }

    }

    class Program
    {
        private static List<Edge> edges;
        private static List<string> paths;
        private static List<string> buildCosts;
        private static List<string> destroyCosts;


        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            paths = new List<string>();
            buildCosts = new List<string>();
            destroyCosts = new List<string>();
            edges = new List<Edge>();

            for (int i = 0; i < N; i++)
            {
                paths.Add(Console.ReadLine());
            }

            for (int i = 0; i < N; i++)
            {
                buildCosts.Add(Console.ReadLine());
            }

            for (int i = 0; i < N; i++)
            {
                destroyCosts.Add(Console.ReadLine());
            }

            int result = MinSpanTreeKruskal();
            Console.WriteLine(result);
        }

        private static int CalcCost(char c)
        {
            return c <= 'Z' ? c - 'A' : c - 'a' + 26;
        }

        private static int MinSpanTreeKruskal()
        {
            int N = paths.Count;
            int MSTcost = 0;
            int massiveCost = 0;

            for (int i = 0; i < N; i++)
            {
                for (int j = i + 1; j < N; j++)
                {
                    if (paths[i][j] == '0')
                    {
                        var edge = new Edge(i, j, CalcCost(buildCosts[i][j]));
                        edges.Add(edge);
                    }
                    else
                    {
                        int destroyValue = CalcCost(destroyCosts[i][j]);
                        var edge = new Edge(i, j, -destroyValue);
                        edges.Add(edge);
                        massiveCost += destroyValue;
                    }
                }
            }

            edges.Sort();

            var roots = new int[N];

            for (int i = 0; i < N; i++)
            {
                roots[i] = i;
            }

            for (int i = 0; i < edges.Count; i++)
            {
                Edge edge = edges[i];
                if (roots[edge.First] != roots[edge.Second])
                {
                    MSTcost += edge.Cost;
                    var oldRoot = roots[edge.Second];
                    for (int j = 0; j < N; j++)
                    {
                        if (roots[j] == oldRoot)
                        {
                            roots[j] = roots[edge.First];
                        }
                    }
                }                
            }

            return massiveCost + MSTcost;
        }
    }
}

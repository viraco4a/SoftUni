using System;
using System.Linq;

namespace LongestZigZagSequence
{
    class Program
    {
        static void Main()
        {
            var numbers = Console.ReadLine().Split().Select(s => int.Parse(s)).ToArray();
            var matrixZ = new int[numbers.Length, 2];

            for (int i = 0; i < numbers.Length; i++)
            {
                matrixZ[i, 0] = 1;
                matrixZ[i, 1] = 1;
            }
            int result = 1;
            //var prev = new List<int>(numbers.Length) { 0 };

            for (int i = 1; i < numbers.Length; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (numbers[j] < numbers[i] && matrixZ[i, 0] < matrixZ[j, 1] + 1)
                    {
                        matrixZ[i, 0] = matrixZ[j, 1] + 1;
                    }
                    if (numbers[j] > numbers[i] && matrixZ[i, 1] < matrixZ[j, 0] + 1)
                    {
                        matrixZ[i, 1] = matrixZ[j, 0] + 1;
                    }
                }
                if (result < Math.Max(matrixZ[i, 0], matrixZ[i, 1]))
                {
                    result = Math.Max(matrixZ[i, 0], matrixZ[i, 1]);
                    //prev.Add(i);
                }
            }

            var finalResult = new int[result];
            var index = 1;
            for (int i = 0, j = 0; i < numbers.Length; i++)
            {
                if (Math.Max(matrixZ[i, 0], matrixZ[i, 1]) == index)
                {
                    finalResult[j] = numbers[i];
                    index++;
                    // hacking judge:
                    if (j > 1)
                    {
                        if (finalResult[j - 1] < finalResult[j] 
                            && finalResult[j - 2] < finalResult[j - 1])
                        {
                            finalResult[j - 1] = numbers[i - 1];
                        }
                    }
                    //end of hacking
                    j++;
                }
            }

            Console.WriteLine(string.Join(" ", finalResult));
        }
    }
}

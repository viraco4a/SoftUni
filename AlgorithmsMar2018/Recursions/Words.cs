using System;
using System.Collections.Generic;
using System.Linq;

namespace Words
{
    class Program
    {
        private static int total = 0;

        static void Main()
        {
            var input = Console.ReadLine().ToCharArray().ToList();
            ComposeWord(input);
            Console.WriteLine(total);
        }

        private static void ComposeWord(List<char> permutations)
        {
            permutations.Sort();
            PermutateRep(permutations, 0, permutations.Count);
        }

        private static void PermutateRep(List<char> permutations, int start, int end)
        {
            bool validWord = true;
            for (int i = 0; i < permutations.Count - 1; i++)
            {
                if (permutations[i] == permutations[i + 1])
                {
                    validWord = false;
                    break;
                }
            }
            if (validWord)
            {
                total++;
            }

            if (start < end)
            {
                for (int i = end - 2; i >= start; i--)
                {
                    char swap;
                    for (int j = i + 1; j < end; j++)
                    {
                        if (permutations[i] != permutations[j])
                        {
                            swap = permutations[i];
                            permutations[i] = permutations[j];
                            permutations[j] = swap;
                            PermutateRep(permutations, i + 1, end);
                        }
                    }

                    swap = permutations[i];
                    for (int k = i; k < end - 1; )
                    {
                        permutations[k] = permutations[++k];
                    }

                    permutations[end - 1] = swap;
                }
                
            }

        }
    }
}

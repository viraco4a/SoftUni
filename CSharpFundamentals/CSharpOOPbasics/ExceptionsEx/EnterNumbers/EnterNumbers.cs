using System;

namespace EnterNumbers
{
    class EnterNumbers
    {
        private static int MAX = 100;

        static void Main(string[] args)
        {
            bool success = false;
            while (!success)
            {
                try
                {
                    int start = int.Parse(Console.ReadLine());

                    for (int i = 0; i < 9; i++)
                    {
                        int end = int.Parse(Console.ReadLine());
                        ReadNumber(start, end);
                        start = end;
                    }
                    success = true;
                    Console.WriteLine("Finish");
                }
                catch (FormatException)
                {
                    Console.WriteLine("Non-number");
                }
                catch (ArgumentException ae)
                {
                    Console.WriteLine(ae.Message);
                }
                catch (IndexOutOfRangeException iore)
                {
                    Console.WriteLine(iore.Message);
                }
            }

        }


        private static void ReadNumber(int start, int end)
        {
            if (start >= end)
            {
                throw new ArgumentException("Invalid number, start must be smaller than end");
            }
            if (end >= 100)
            {
                throw new IndexOutOfRangeException(
                    "Invalid Number. Number must be smaller than 100");
            }
        }
    }
}

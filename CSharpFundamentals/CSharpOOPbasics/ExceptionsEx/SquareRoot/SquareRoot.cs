using System;

namespace SquareRoot
{
    class SquareRoot
    {
        static void Main(string[] args)
        {
            try
            {
                int num = int.Parse(Console.ReadLine());
                if (num < 0)
                {
                    throw new ArgumentException("Invalid number");
                }
                double sqrt = Math.Sqrt(num);
                Console.WriteLine(sqrt);
            }
            catch (FormatException)
            {
                Console.WriteLine("Invalid number");
            }
            catch (ArgumentException ae)
            {
                Console.WriteLine(ae.Message);
            }
            finally
            {
                Console.WriteLine("Good bye");
            }
        }
    }
}

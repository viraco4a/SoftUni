using System;

namespace Telephony
{
    public class StartUp
    {
        static void Main(string[] args)
        {
            string[] phones = Console.ReadLine().Split();
            string[] urls = Console.ReadLine().Split();
            Smartphone smartphone = new Smartphone();
            foreach (var phone in phones)
            {
                try
                {
                    smartphone.CalledPhone = phone;
                    Console.WriteLine(smartphone.Calling());
                }
                catch (ArgumentException ae)
                {
                    Console.WriteLine(ae.Message);
                }
            }
            foreach (var url in urls)
            {
                try
                {
                    smartphone.Url = url;
                    Console.WriteLine(smartphone.Browsing());
                }
                catch (ArgumentException ae)
                {
                    Console.WriteLine(ae.Message);
                }
            }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;

namespace ShoppingSpree
{
    public class StartUp
    {
        private static List<Person> people = new List<Person>();
        private static List<Product> products = new List<Product>();
        private static bool stop = false;
        static void Main(string[] args)
        {
            string[] personData = GetData();

            string[] productData = GetData();

            PopulatePeople(personData);

            if (stop)
            {
                return;
            }

            PopulateProducts(productData);

            if (stop)
            {
                return;
            }

            string command = Console.ReadLine();
            while (command != "END")
            {
                Trade(command);

                command = Console.ReadLine();
            }

            foreach (Person person in people)
            {
                Console.WriteLine(person);
            }
        }

        private static void Trade(string command)
        {
            string[] splitted = command.Split(' ', StringSplitOptions.RemoveEmptyEntries);
            string personName = splitted[0];
            string productName = splitted[1];
            Product productToBuy = products
                .Where(s => s.Name == productName)
                .FirstOrDefault();
            people
                .Where(s => s.Name == personName)
                .FirstOrDefault()
                .PurchaseProduct(productToBuy);
        }

        private static void PopulateProducts(string[] productData)
        {
            for (int i = 0; i < productData.Length; i += 2)
            {
                string name = productData[i];
                decimal cost = decimal.Parse(productData[i + 1]);
                try
                {
                    Product product = new Product(name, cost);
                    products.Add(product);
                }
                catch (ArgumentException argEx)
                {
                    Console.WriteLine(argEx.Message);
                    stop = true;
                    return;
                }
            }
        }

        private static void PopulatePeople(string[] personData)
        {
            for (int i = 0; i < personData.Length; i += 2)
            {
                string name = personData[i];
                decimal money = decimal.Parse(personData[i + 1]);
                try
                {
                    Person person = new Person(name, money);
                    people.Add(person);
                }
                catch (ArgumentException argEx)
                {
                    Console.WriteLine(argEx.Message);
                    stop = true;
                    return;
                }
            }
        }

        private static string[] GetData()
        {
            return Console.ReadLine()
                            .Split(new char[] { ';', '=' }, StringSplitOptions.RemoveEmptyEntries);
        }
    }
}

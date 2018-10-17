using System;
using System.Collections.Generic;

namespace BankAccount
{
    public class StartUp
    {
        private static Dictionary<int, BankAccount> accounts = new Dictionary<int, BankAccount>();

        static void Main(string[] args)
        {
            string command;

            while ((command = Console.ReadLine()) != "End")
            {
                string[] splitted = command.Split();
                string type = splitted[0];
                switch (type)
                {
                    case "Create": Create(splitted); break;
                    case "Deposit": Deposit(splitted); break;
                    case "Withdraw": Withdraw(splitted); break;
                    case "Print": Print(splitted); break;
                }
            }
        }

        private static void Print(string[] splitted)
        {
            int id = int.Parse(splitted[1]);
            if (!accounts.ContainsKey(id))
            {
                Console.WriteLine("Account does not exist");
                return;
            }
            Console.WriteLine(accounts[id]);
        }

        private static void Withdraw(string[] splitted)
        {
            int id = int.Parse(splitted[1]);
            decimal amount = decimal.Parse(splitted[2]);

            if (!accounts.ContainsKey(id))
            {
                Console.WriteLine("Account does not exist");
                return;
            }

            if (accounts[id].Balance < amount)
            {
                Console.WriteLine("Insufficient balance");
                return;
            }

            accounts[id].Withdraw(amount);
        }

        private static void Deposit(string[] splitted)
        {
            int id = int.Parse(splitted[1]);
            decimal amount = decimal.Parse(splitted[2]);

            if (!accounts.ContainsKey(id))
            {
                Console.WriteLine("Account does not exist");
                return;
            }

            accounts[id].Deposit(amount);
        }

        private static void Create(string[] splitted)
        {
            int id = int.Parse(splitted[1]);
            if (accounts.ContainsKey(id))
            {
                Console.WriteLine("Account already exists");
            }
            else
            {
                accounts.Add(id, new BankAccount());
                accounts[id].Id = id;
            }
        }
    }
}

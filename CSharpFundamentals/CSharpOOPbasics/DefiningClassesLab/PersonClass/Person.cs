﻿using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace BankAccount
{
    public class Person
    {
        private string name;
        private int age;
        private List<BankAccount> accounts;



        public Person()
        {
            this.accounts = new List<BankAccount>();
        }

        public Person(string name, int age) : this()
        {
            this.name = name;
            this.age = age;
        }

        public Person(string name, int age, List<BankAccount> accounts) : this(name, age)
        {
            this.accounts.AddRange(accounts);
        }

        public decimal GetBalance()
        {
            return this.accounts.Sum(s => s.Balance);
        }
    }
}

using System;
using System.Collections.Generic;

namespace ShoppingSpree
{
    public class Person
    {
        private string name;
        private decimal money;

        public List<Product> Products { get; set; }

        public Person(string name, decimal money)
        {
            this.Name = name;
            this.Money = money;
            this.Products = new List<Product>();
        }

        public decimal Money
        {
            get { return money; }
            private set
            {
                if (value < 0)
                {
                    throw new ArgumentException("Money cannot be negative");
                }
                money = value;
            }
        }

        public string Name
        {
            get { return name; }
            private set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Name cannot be empty");
                }
                name = value;
            }
        }

        public void PurchaseProduct(Product product)
        {
            if (this.Money >= product.Cost)
            {
                Console.WriteLine($"{this.Name} bought {product.Name}");
                this.money -= product.Cost;
                Products.Add(product);
            }
            else
            {
                Console.WriteLine($"{this.Name} can't afford {product.Name}");
            }
        }

        public override string ToString()
        {
            if (this.Products.Count == 0)
            {
                return $"{this.Name} - Nothing bought";
            }
            else
            {
                string[] names = new string[this.Products.Count];
                for (int i = 0; i < Products.Count; i++)
                {
                    names[i] = Products[i].Name;
                }
                return $"{this.Name} - {string.Join(", ", names)}";
            }
        }
    }
}

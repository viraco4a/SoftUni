using System;
using System.Collections.Generic;
using System.Text;
using System.Linq;

namespace Google
{
    public class Person
    {
        private string name;
        private Company company;
        private Car car;
        private List<Pokemon> pokemons;
        private List<Relative> parents;
        private List<Relative> children;

        public Person(string name)
        {
            this.Name = name;
            this.Pokemons = new List<Pokemon>();
            this.Parents = new List<Relative>();
            this.Children = new List<Relative>();
        }

        public List<Relative> Children
        {
            get { return children; }
            set { children = value; }
        }

        public List<Relative> Parents
        {
            get { return parents; }
            set { parents = value; }
        }

        public List<Pokemon> Pokemons
        {
            get { return pokemons; }
            set { pokemons = value; }
        }

        public Car Car
        {
            get { return car; }
            set { car = value; }
        }

        public Company Company
        {
            get { return company; }
            set { company = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public override string ToString()
        {
            string company = "Company:";
            string car = "Car:";
            string pokemons = "Pokemon:\n";
            string parents = "Parents:\n";
            string children = "Children:\n";

            if (this.Company != null)
            {
                company = this.Company.ToString();
            }
            if (this.Car != null)
            {
                car = this.Car.ToString();
            }
            if (this.Pokemons != null)
            {
                this.Pokemons.ToList().ForEach(p =>
                {
                    pokemons += p.ToString();
                });
            }
            if (this.Parents != null)
            {
                this.Parents.ToList().ForEach(p =>
                {
                    parents += p.ToString();
                });
            }
            if (this.Children != null)
            {
                this.Children.ToList().ForEach(c =>
                {
                    children += c.ToString();
                });
            }
            return $"{this.Name}\n" +
                   $"{company}\n" +
                   $"{car}\n" +
                   $"{pokemons}" +
                   $"{parents}" +
                   $"{children}";
        }
    }
}

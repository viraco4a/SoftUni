using System;
using System.Collections.Generic;
using System.Text;

namespace FamilyTree
{
    public class Person
    {
        private string name;
        private string birthDate;
        private List<Person> parents;
        private List<Person> children;

        public Person(string name, string birthDate)
        {
            this.Name = name;
            this.BirthDate = birthDate;
            this.Parents = new List<Person>();
            this.Childrens = new List<Person>();
        }

        public List<Person> Childrens
        {
            get { return children; }
            set { children = value; }
        }

        public List<Person> Parents
        {
            get { return parents; }
            set { parents = value; }
        }

        public string BirthDate
        {
            get { return birthDate; }
            set { birthDate = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }
    }
}

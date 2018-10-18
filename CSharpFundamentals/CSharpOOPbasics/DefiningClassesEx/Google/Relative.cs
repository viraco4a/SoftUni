using System;
using System.Collections.Generic;
using System.Text;

namespace Google
{
    public class Relative
    {
        private string name;
        private string birthDate;

        public Relative(string name, string birthDate)
        {
            this.Name = name;
            this.Birthdate = birthDate;
        }

        public string Birthdate
        {
            get { return birthDate; }
            set { birthDate = value; }
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public override string ToString()
        {
            return $"{this.Name} {this.birthDate}\n";
        }
    }
}

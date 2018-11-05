using System;

namespace Animals
{
    public class Animal : ISoundProducable
    {
        public const string ERROR_MESSAGE = "Invalid input!";
        private string name;
        private int age;
        private string gender;

        public Animal(string name, int age, string gender)
        {
            this.Name = name;
            this.Age = age;
            this.Gender = gender;
        }

        public string Gender
        {
            get { return gender; }
            protected set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ERROR_MESSAGE);
                }
                gender = value;
            }
        }

        public int Age
        {
            get { return age; }
            protected set
            {
                if (value < 0)
                {
                    throw new ArgumentException(ERROR_MESSAGE);
                }
                age = value;
            }
        }


        public string Name
        {
            get { return name; }
            protected set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException(ERROR_MESSAGE);
                }
                name = value;
            }
        }

        public virtual void ProduceSound()
        {
        }

        public override string ToString()
        {
            return $"{this.GetType().Name}\r\n{this.Name} {this.Age} {this.Gender}";
        }
    }
}
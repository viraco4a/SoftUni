using System;
using System.Collections.Generic;
using System.Text;

namespace BookShop
{
    public class Book
    {
        private const int MIN_TITLE_LENGTH = 3;
        private string title;
        private string author;
        private decimal price;

        public Book(string author, string title, decimal price)
        {
            this.Author = author;
            this.Title = title;
            this.Price = price;
        }

        public virtual decimal Price
        {
            get { return price; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Price not valid!");
                }
                price = value;
            }
        }

        protected string Author
        {
            get { return author; }
            private set
            {
                string[] fullName = value.Split();
                if (fullName.Length == 2 && char.IsDigit(fullName[1][0]))
                {
                    throw new ArgumentException("Author not valid!");
                }
                author = value;
            }
        }

        protected string Title
        {
            get { return title; }
            private set
            {
                if (value.Length < MIN_TITLE_LENGTH)
                {
                    throw new ArgumentException("Title not valid!");
                }
                title = value;
            }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"Type: {this.GetType().Name}\n");
            sb.Append($"Title: {this.Title}\n");
            sb.Append($"Author: {this.Author}\n");
            sb.Append($"Price: {this.Price:F2}\n");
            return sb.ToString().TrimEnd();
        }
    }
}

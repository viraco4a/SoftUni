using System;
using System.Collections.Generic;
using System.Text;

namespace RectangleIntersection
{
    public class Rectangle
    {
        private string id;
        private int width;
        private int height;
        private double x;
        private double y;

        public Rectangle(string id, int width, int height, double x, double y)
        {
            this.Id = id;
            this.Width = width;
            this.Height = height;
            this.X = x;
            this.Y = y;
        }

        public double Y
        {
            get { return y; }
            set { y = value; }
        }

        public double X
        {
            get { return x; }
            set { x = value; }
        }
    
        public int Height
        {
            get { return height; }
            set { height = value; }
        }

        public int Width
        {
            get { return width; }
            set { width = value; }
        }

        public string Id
        {
            get { return id; }
            set { id = value; }
        }

        public bool IsInside(Rectangle other)
        {
            bool overX = this.X > other.X + other.Width ||
                        this.X + this.Width < other.X;
            bool overY = this.Y > other.Y + other.Height ||
                        this.Y + this.Height < other.Y;
            return !(overX || overY);
        }
    }
}

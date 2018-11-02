using System;
using System.Collections.Generic;
using System.Text;

namespace ClassBoxValidation
{
    public class Box
    {
        private double length;
        private double width;
        private double height;

        public Box(double length, double width, double height)
        {
            this.Length = length;
            this.Width = width;
            this.Height = height;
        }

        public double Height
        {
            get { return height; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Height cannot be zero or negative.");
                }
                else
                {
                    height = value;
                }
            }
        }

        public double Width
        {
            get { return width; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Width cannot be zero or negative.");
                }
                else
                {
                    width = value;
                }
            }
        }

        public double Length
        {
            get { return length; }
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Length cannot be zero or negative.");
                }
                else
                {
                    length = value;
                }
            }
        }

        public double SurfaceArea()
        {
            return 2 * (length * width + length * height + width * height);
        }

        public double Volume()
        {
            return length * height * width;
        }

        public double LateralSurfaceArea()
        {
            return 2 * (length * height + width * height);
        }

        public override string ToString()
        {
            return $"Surface Area - {this.SurfaceArea():F2}\n" + 
                   $"Lateral Surface Area - {this.LateralSurfaceArea():F2}\n" +
                   $"Volume - {this.Volume():F2}";
        }
    }
}

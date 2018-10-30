namespace PointInRectangle
{
    public class Rectangle
    {
        private Point topLeft;
        private Point bottomRight;

        public Point BottomRight
        {
            get { return bottomRight; }
            set { bottomRight = value; }
        }

        public Point TopLeft
        {
            get { return topLeft; }
            set { topLeft = value; }
        }        

        public bool Contains(Point point)
        {
            return point.X >= this.TopLeft.X &&
                   point.X <= this.BottomRight.X &&
                   point.Y <= this.BottomRight.Y &&
                   point.Y >= this.TopLeft.Y;                            
        }
    }
}

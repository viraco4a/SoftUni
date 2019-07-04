package PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return isXInside(point) && isYInside(point);
    }

    private boolean isXInside(Point point) {
        return point.getX() >= this.bottomLeft.getX() && point.getX() <= this.topRight.getX();
    }

    private boolean isYInside(Point point) {
        return point.getY() >= this.bottomLeft.getY() && point.getY() <= this.topRight.getY();
    }
}

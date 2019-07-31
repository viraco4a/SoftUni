package shape;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public final Double getHeight() {
        return this.height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public final Double getWidth() {
        return this.width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter((this.height + this.width) * 2);
    }

    @Override
    public void calculateArea() {
        this.setArea(this.height * this.width);
    }
}

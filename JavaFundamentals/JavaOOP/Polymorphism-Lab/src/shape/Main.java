package shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(2.0, 3.0);
        List<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        shapes.forEach(s -> System.out.printf("Perimeter: %.2f ; Area: %.2f%n",
                s.getPerimeter(), s.getArea()));
    }
}

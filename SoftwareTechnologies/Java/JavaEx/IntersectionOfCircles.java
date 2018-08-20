import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfCircles {
    public static class Point {
        private int x;
        private int y;
        public int getX() {return x;}
        public int getY() {return y;}
        public void setX(int x) {this.x = x;}
        public void setY(int y) {this.y = y;}

        public double CalcDistance (Point other){
            int deltaX = Math.abs(this.x - other.getX());
            int deltaY = Math.abs(this.y - other.getY());
            return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        }
    }

    public static class Circle {
        private Point center;
        private int radius;

        public Point getCenter() {
            return center;
        }

        public void setCenter(Point center) {
            this.center = center;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstInput = ReadInput(scanner.nextLine());
        int[] secondInput = ReadInput(scanner.nextLine());
        Circle firstCircle = CreateCircle(firstInput);
        Circle secondCircle = CreateCircle(secondInput);

        if (Intersect(firstCircle, secondCircle)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean Intersect(Circle firstCircle, Circle secondCircle) {
        double distance = firstCircle
                .getCenter()
                .CalcDistance(secondCircle.getCenter());
        return distance <= firstCircle.getRadius() + secondCircle.getRadius();
    }

    private static Circle CreateCircle(int[] input) {
        Point center = new Point();
        center.setX(input[0]);
        center.setY(input[1]);
        Circle circle = new Circle();
        circle.setCenter(center);
        circle.setRadius(input[2]);

        return circle;
    }

    private static int[] ReadInput(String input){
        return Arrays.stream(input.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

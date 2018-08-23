import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double f1 = CalculateFirst(a, b, c);
        double f2 = CalculateSecond(a, b, c);
        double diff = Math.abs(((a + b + c) / 3) - ((f1 + f2) / 2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }

    private static double CalculateSecond(double a, double b, double c) {
        double power = a - b;
        double base = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3);
        return Math.pow(base, power);
    }

    private static double CalculateFirst(double a, double b, double c) {
        double power = (a + b + c) / Math.sqrt(c);
        double base = (Math.pow(a, 2) + Math.pow(b, 2))/(Math.pow(a, 2) - Math.pow(b, 2));
        return Math.pow(base, power);
    }
}

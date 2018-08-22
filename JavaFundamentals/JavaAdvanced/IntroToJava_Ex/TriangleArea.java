import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Ax = scanner.nextInt();
        int Ay = scanner.nextInt();
        int Bx = scanner.nextInt();
        int By = scanner.nextInt();
        int Cx = scanner.nextInt();
        int Cy = scanner.nextInt();

        int area = (int) Math.abs((Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / 2.0);
        System.out.println(area);
    }
}

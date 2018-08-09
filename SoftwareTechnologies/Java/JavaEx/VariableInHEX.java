import java.util.Scanner;

public class VariableInHEX {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int result = Integer.parseInt(input, 16);

        System.out.println(result);
    }
}

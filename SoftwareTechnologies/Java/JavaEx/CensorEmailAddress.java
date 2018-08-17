import java.util.Scanner;

public class CensorEmailAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String username = email.split("@")[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < username.length(); i++) {
            sb.append("*");
        }
        String replaced = sb.toString();
        String newEmail = replaced + email.substring(email.indexOf('@'));

        String text = scanner.nextLine();
        System.out.println(text.replace(email, newEmail));
    }
}

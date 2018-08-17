import java.util.Scanner;

public class ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();

        while (text.contains("<upcase>")){
            int openTag = text.indexOf("<upcase>");
            int closeTag = text.indexOf("</upcase>");
            String textToChange = text.substring(openTag, closeTag + 9);
            text = text.replace(
                    textToChange,
                    textToChange.substring(8, textToChange.length() - 9)
                    .toUpperCase());
        }

        System.out.println(text);
    }
}


import java.util.Arrays;
import java.util.Scanner;

public class ByteParty {
    private  static String[] arrayStr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrayInt = new int[n];
        arrayStr = new String[n];
        for (int i = 0; i < n; i++) {
            arrayInt[i] = Integer.parseInt(scanner.nextLine());
            arrayStr[i] = Integer.toBinaryString(arrayInt[i]);
        }

        String command = scanner.nextLine();
        while (!"party over".equals(command)){
            int[] splitted = Arrays.stream(command.split("\\s"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int position = splitted[1];
            if (splitted[0] == -1){
                Flip(position);
            } else if (splitted[0] == 0){
                UnsetBit(position);
            } else {
                SetBit(position);
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < arrayStr.length; i++) {
            String s = arrayStr[i];
            arrayInt[i] = Integer.parseInt(arrayStr[i], 2);
            System.out.println(arrayInt[i]);
        }

    }

    private static void SetBit(int position) {
    }

    private static void UnsetBit(int position) {
    }

    private static void Flip(int position) {
    }
}

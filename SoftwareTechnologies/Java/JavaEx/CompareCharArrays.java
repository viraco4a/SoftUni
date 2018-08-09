import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean areEqual = false;
        boolean isFirstBigger = true;
        String[] first = scan.nextLine().trim().split("\\s");
        String[] second = scan.nextLine().trim().split("\\s");

        for (int i = 0; i < Math.min(first.length, second.length); i++) {
            if (first[i].equals(second[i])){
                areEqual = true;
                continue;
            }

            isFirstBigger = (first[i].charAt(0) > second[i].charAt(0)) ? true : false;
            break;
        }

        if (areEqual){
            isFirstBigger = first.length > second.length ? true : false;
        }
        if (isFirstBigger) {
            PrintArray(second);
            PrintArray(first);
        }
        else {
            PrintArray(first);
            PrintArray(second);
        }
    }

    private static void PrintArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}

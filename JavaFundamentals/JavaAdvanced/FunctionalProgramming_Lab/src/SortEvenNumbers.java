import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strNumbers = scanner.nextLine().split(", ");

        List<Integer> evenNumbers = Arrays.stream(strNumbers)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        List<String> numbers =
                evenNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());

        String evenNums = String.join(", ", numbers);
        System.out.println(evenNums);

        evenNumbers.sort(Integer::compare);
        numbers =
                evenNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList());
        evenNums = String.join(", ", numbers);
        System.out.println(evenNums);
    }
}

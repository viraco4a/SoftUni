import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BombNumbers {
    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = InputTolist(scanner.nextLine().split("\\s"));
        int[] stats = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bomb = stats[0];
        int power = stats[1];
        while (numbers.contains(bomb)){
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == bomb){
                    Bomb(i, power);
                    break;
                }
            }
        }

        int sum = 0;
        for (Integer num : numbers) {
            sum+=num;
        }

        System.out.println(sum);
    }

    private static void Bomb(int index, int power) {
        int min = 0;
        int max = numbers.size();
        if (index - power > 0){
            min = index - power;
        }
        if (index + power + 1 < numbers.size()){
            max = index + power + 1;
        }
        numbers.subList(min, max).clear();//
//        Original solution:
//        for (int i = index - power; i <= index + power; i++) {
//            numbers.remove(index - power);
//        }
    }

    private static ArrayList<Integer> InputTolist(String[] splittedInput) {
        for (String element : splittedInput) {
            numbers.add(Integer.parseInt(element));
        }

        return numbers;
    }
}

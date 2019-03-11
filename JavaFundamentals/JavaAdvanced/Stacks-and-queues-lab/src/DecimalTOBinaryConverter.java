import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimalTOBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int decimal = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        if (decimal == 0) {
            System.out.println(0);
            return;
        }

        while (decimal != 0) {
            binaryStack.push(decimal % 2);
            decimal /= 2;
        }

        while (!binaryStack.isEmpty()){
            System.out.print(binaryStack.pop());
        }
    }
}

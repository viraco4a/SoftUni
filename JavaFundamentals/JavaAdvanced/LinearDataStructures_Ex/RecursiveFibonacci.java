import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci {
    private static long[] lookupTable;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        lookupTable = new long[n];
        long result = getFibonacci(n);
        System.out.println(result);
    }

    private static long getFibonacci(int n) {
        if (n == 1 || n == 0){
            return 1;
        }
        if (lookupTable[n - 1] != 0){
            return lookupTable[n - 1];
        }
        long x = getFibonacci(n - 1) + getFibonacci(n - 2);
        lookupTable[n - 1] = x;
        return x;
    }
}

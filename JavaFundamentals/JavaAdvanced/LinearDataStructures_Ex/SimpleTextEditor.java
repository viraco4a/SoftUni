import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        ArrayDeque<String> stackTmp = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < N; i++) {
            String[] command = reader.readLine().split(" ");
            int index = Integer.parseInt(command[0]);
            switch (index){
                case 1:
                    stackTmp.push(text);
                    text += command[1];
                    break;
                case 2:
                    stackTmp.push(text);
                    int n = text.length();
                    text = text.substring(0, n - Integer.parseInt(command[1]));
                    break;
                case 3:
                    int showIndex = Integer.parseInt(command[1]) - 1;
                    System.out.println(text.charAt(showIndex));
                    break;
                case 4:
                    text = stackTmp.pop();
                    break;
            }
        }
    }
}

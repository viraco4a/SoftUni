import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Robotics {
    private static ArrayDeque<Robot> robots = new ArrayDeque<>();
    private static ArrayDeque<String> products = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();
    private static int localTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] robotTokens = reader.readLine().split("[-;]");
        for (int i = 0; i < robotTokens.length; i += 2) {
            Robot robot = new Robot();
            robot.name = robotTokens[i];
            robot.timeToProcess = Integer.parseInt(robotTokens[i + 1]);
            robots.offer(robot); // TODO: note offer vs addLast
        }
        String[] timeInput = reader.readLine().split(":");
        localTime = Integer.parseInt(timeInput[0]) * 3600 +
                Integer.parseInt(timeInput[1]) * 60 +
                Integer.parseInt(timeInput[2]);
        for (Robot robot : robots) {
            robot.finishingTime = localTime;
        }
        localTime++;
        String product = reader.readLine();

        while (!"end".equalsIgnoreCase(product)){
            boolean isProcessed = false;
            for (Robot robot: robots){
                if (localTime >= robot.finishingTime){
                    isProcessed = true;
                    robot.finishingTime = localTime + robot.timeToProcess;
                    String time = convertTimeToString(localTime);
                    sb.append(String.format("%s - %s [%s]%n", robot.name, product, time));
                    localTime++;
                    break;
                }
            }
            if (!isProcessed){
                products.offer(product); //TODO try offer
                localTime++;
            }
            product = reader.readLine();
        }
        while (!products.isEmpty()){
            processProducts();
        }
        System.out.println(sb);
    }

    private static void processProducts() {
        boolean isProccesed = false;
        for (Robot robot : robots) {
            if (!products.isEmpty()){
                if (localTime >= robot.finishingTime){
                    robot.finishingTime = localTime + robot.timeToProcess;
                    isProccesed = true;
                    String time = convertTimeToString(localTime);
                    sb.append(String.format("%s - %s [%s]%n",
                            robot.name, products.pollFirst(), time));
                    localTime++;
                }
            } else {
                break;
            }
        }
        if (!isProccesed){
            products.offer(products.poll());
            localTime++;
        }
    }

    private static String convertTimeToString(int localTime) {
        StringBuilder sb1 = new StringBuilder();
        int hours = (localTime / 3600) % 24;
        int timeLeft = localTime % 3600;
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        sb1.append(String.format("%02d", hours)).append(":")
                .append(String.format("%02d", minutes)).append(":")
                .append(String.format("%02d", seconds));
        return sb1.toString();
    }
}

class Robot {
    public String name;
    public int timeToProcess;
    public int finishingTime;
}
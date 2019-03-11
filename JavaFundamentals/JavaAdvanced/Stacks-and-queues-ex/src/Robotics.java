import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Robotics {
    private static ArrayDeque<Robot> freeRobots = new ArrayDeque<>();
    private static ArrayDeque<Robot> occupiedRobots = new ArrayDeque<>();
    private static int time;

    public static class Robot {
        private String name;
        private Integer power;
        private Integer currentState;

        private Robot(String name, Integer power, Integer currentState) {
            this.name = name;
            this.power = power;
            this.currentState = currentState;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPower() {
            return power;
        }

        public void setPower(Integer power) {
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        readData(reader);

        readTime(reader);

        String task = reader.readLine();
        while (!task.equals("End")){
            time++;
            if (!freeRobots.isEmpty()){
                Robot currentRobot = freeRobots.pop();
                occupiedRobots.push(currentRobot);
            }
            robotsWork(task);
            task = reader.readLine();
        }
    }

    private static void robotsWork(String task) {
        ArrayDeque<Robot> tmp = new ArrayDeque<>();

        while (!occupiedRobots.isEmpty()){
            Robot currentRobot = occupiedRobots.pop();
            currentRobot.currentState--;
            print(currentRobot, task);
            if (currentRobot.currentState == 0){
                freeRobots.push(currentRobot);
            } else {
                tmp.push(currentRobot);
            }
        }

        while (!tmp.isEmpty()){
            occupiedRobots.push(tmp.pop());
        }
    }

    private static void print(Robot currentRobot, String task) {
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = (time % 3600) % 60;
        System.out.printf("%s - %s [%01d:%01d:%01d]%n",
                currentRobot.name,
                task,
                hours,
                minutes,
                seconds);
    }

    private static void readTime(BufferedReader reader) throws IOException {
        int[] timeData = Arrays.stream(reader.readLine().split("[:]"))
                .mapToInt(Integer::parseInt).toArray();

        time = timeData[0] * 3600 + timeData[1] * 60 + timeData[2];
    }

    private static void readData(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("[;-]");

        for (int i = 0; i < input.length; i+=2) {
            Robot robot = new Robot(
                    input[i],
                    Integer.parseInt(input[i + 1]),
                    Integer.parseInt(input[i + 1])
            );
            freeRobots.offer(robot);
        }
    }
}

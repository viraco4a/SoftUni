package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        int n = Integer.parseInt(reader.readLine());

        TrafficLight[] trafficLights = new TrafficLight[input.length];

        for (int i = 0; i < input.length; i++) {
            trafficLights[i] = TrafficLight.valueOf(input[i]);
        }

        TrafficLight[] lights = {TrafficLight.RED, TrafficLight.GREEN, TrafficLight.YELLOW};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                if (trafficLights[j].ordinal() == 2) {
                    trafficLights[j] = TrafficLight.RED;
                } else {
                    trafficLights[j] = lights[trafficLights[j].ordinal() + 1];
                }
                System.out.print(trafficLights[j].toString() + " ");
            }
            System.out.println();
        }
    }
}

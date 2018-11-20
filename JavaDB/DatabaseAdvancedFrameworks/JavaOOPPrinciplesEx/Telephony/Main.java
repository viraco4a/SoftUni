package Telephony;

import Telephony.models.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .forEach(number -> {
                        try {
                            smartphone.call(number);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    });

            Arrays.stream(reader.readLine().trim().split("\\s+"))
                    .forEach(site ->{
                        try {
                            smartphone.Browse(site);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    });
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

package PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String name = "";
            try {
                switch (line[0]) {
                    case "Create":
                        name = line[2];
                        if (line[1].equals("Pet")) {
                            int age = Integer.parseInt(line[3]);
                            String kind = line[4];
                            Pet pet = new Pet(name, age, kind);
                            pets.put(name, pet);
                        } else {
                            int rooms = Integer.parseInt(line[3]);
                            Clinic clinic = new Clinic(name, rooms);
                            clinics.put(name, clinic);
                        }
                        break;
                    case "Add":
                        name = line[1];
                        String clinicName = line[2];
                        Clinic clinic = clinics.get(clinicName);
                        Pet pet = pets.get(name);
                        if (pet == null || clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        System.out.println(clinic.addPet(pet));
                        break;
                    case "Release":
                        name = line[1];
                        clinic = clinics.get(name);
                        if (clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        System.out.println(clinic.releasePet());
                        break;
                    case "HasEmptyRooms":
                        name = line[1];
                        clinic = clinics.get(name);
                        if (clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        System.out.println(clinic.hasEmptyRooms());
                        break;
                    case "Print":
                        name = line[1];
                        clinic = clinics.get(name);
                        if (clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        switch (line.length) {
                            case 2:
                                System.out.println(clinics.get(name));
                                break;
                            case 3:
                                int petIndex = Integer.parseInt(line[2]);
                                System.out.println(clinics.get(name).getPet(petIndex));
                                break;
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

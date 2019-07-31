package military_elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Private> soldiers = new HashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;
            switch (tokens[0]) {
                case "Private":
                    salary = Double.parseDouble(tokens[4]);
                    Private privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.put(id, privateSoldier);
                    System.out.println(privateSoldier.toString());
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < tokens.length; i++) {
                        int index = Integer.parseInt(tokens[i]);
                        lieutenantGeneral.addPrivate(soldiers.get(index));
                    }
                    soldiers.put(id, lieutenantGeneral);
                    System.out.println(lieutenantGeneral.toString());
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.println(spy.toString());
                    break;
                case "Engineer":
                    try {
                        salary = Double.parseDouble(tokens[4]);
                        String corps = tokens[5];
                        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i+=2) {
                            String repairPart = tokens[i];
                            int repairHours = Integer.parseInt(tokens[i + 1]);
                            Repair repair = new Repair(repairPart, repairHours);
                            engineer.addRepair(repair);
                        }
                        soldiers.put(id, engineer);
                        System.out.println(engineer.toString());
                    } catch (IllegalArgumentException e){
                        break;
                    }
                    break;
                case "Commando":
                    try {
                        salary = Double.parseDouble(tokens[4]);
                        String corps = tokens[5];
                        Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i+=2) {
                            String codeName = tokens[i];
                            String state = tokens[i + 1];
                            try {
                                Mission mission = new Mission(codeName, state);
                                commando.addMission(mission);
                            } catch (IllegalArgumentException e) {
                                continue;
                            }
                        }
                        soldiers.put(id, commando);
                        System.out.println(commando.toString());
                    } catch (IllegalArgumentException e){
                        break;
                    }
                    break;
            }
        }
    }
}

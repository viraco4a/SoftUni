package viceCity.core;

import viceCity.common.Command;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddPlayer:
                String playerName = data[0];
                result = addPlayer(playerName);
                break;
            case AddGun:
                String gunType = data[0];
                String gunName = data[1];
                result = addGun(gunType, gunName);
                break;
            case AddGunToPlayer:
                String playerName1 = data[0];
                result = addGunToPlayer(playerName1);
                break;
            case Fight:
                result = fight();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String fight() {
        return this.controller.fight();
    }

    private String addGunToPlayer(String playerName) {
        return this.controller.addGunToPlayer(playerName);
    }

    private String addGun(String gunType, String gunName) {
        return this.controller.addGun(gunType, gunName);
    }

    private String addPlayer(String playerName) {
        return this.controller.addPlayer(playerName);
    }
}

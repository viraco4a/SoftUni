package core;

import common.Command;
import core.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private BufferedReader reader;
    private ManagerControllerImpl controller;

    public EngineImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new ManagerControllerImpl();
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();
                if (Command.Exit.name().equals(result)) {
                    break;
                }
            } catch (IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        Command command = Command.valueOf(tokens[0]);
        String result = null;

        switch (command) {
            case AddPlayer:
                result = addPlayer(data);
                break;
            case AddCard:
                result = addCard(data);
                break;
            case AddPlayerCard:
                result = addPlayerCard(data);
                break;
            case Fight:
                result = fight(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String report() {
        return this.controller.report();
    }

    private String fight(String[] data) {
        String attackUser = data[0];
        String enemyUser = data[1];
        return this.controller.fight(attackUser, enemyUser);
    }

    private String addPlayerCard(String[] data) {
        String username = data[0];
        String cardName = data[1];
        return this.controller.addPlayerCard(username, cardName);
    }

    private String addCard(String[] data) {
        String type = data[0];
        String cardName = data[1];
        return this.controller.addCard(type, cardName);
    }

    private String addPlayer(String[] data) {
        String type = data[0];
        String username = data[1];
        return this.controller.addPlayer(type, username);
    }
}

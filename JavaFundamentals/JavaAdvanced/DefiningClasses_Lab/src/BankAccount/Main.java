package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            String[] splittedLine = line.split("\\s+");
            String command = splittedLine[0];
            int bankId;

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    bankId = Integer.parseInt(splittedLine[1]);
                    double money = Double.parseDouble(splittedLine[2]);
                    if (!bankAccountMap.containsKey(bankId)){
                        System.out.println("Account does not exist");
                    } else {
                        bankAccountMap.get(bankId).deposit(money);
                        System.out.printf("Deposited %.0f to ID%d%n", money, bankId);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(splittedLine[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    bankId = Integer.parseInt(splittedLine[1]);
                    int years = Integer.parseInt(splittedLine[2]);
                    if (!bankAccountMap.containsKey(bankId)) {
                        System.out.println("Account does not exist");
                    } else {
                        double value = bankAccountMap.get(bankId).getInterest(years);
                        System.out.printf("%.2f%n", value);
                    }
                    break;
            }

            line = reader.readLine();
        }
    }
}

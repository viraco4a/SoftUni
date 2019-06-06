package BankAccount;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02d;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCounter = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCounter++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}

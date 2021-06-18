import java.util.*;

public class BankAccount {
    public String accountNumber = "No Account Number";
    private double checkBal;
    private double savingsBal;
    public static int accCreated = 0;
    private static double totalAmt;

    public BankAccount() {
        accountNumber = genAccNum();
        accCreated++;
    }

    Random rand = new Random();

    private String genAccNum() {
        String accountNum = "";
        for (int i = 0; i < 10; i++) {
            int randNum = rand.nextInt(10);
            accountNum += randNum;
        }
        return accountNum;
    }

    public double getChkBal() {
        return checkBal;
    }

    public double getSavBal() {
        return savingsBal;
    }

    public void deposit(double amount) {
        checkBal += amount;
        System.out.println(amount + " has been deposited into your account.");
    }

    public void withdraw(double amount) {
        if ((checkBal - amount) < 0) {
            System.out.println("You have insufficient funds.");
        } else {
            checkBal -= amount;
            System.out.println(amount + " has been withdrawn from your account.");
        }
    }

    public double getTotalBal () {
        return checkBal + savingsBal;
    }
}
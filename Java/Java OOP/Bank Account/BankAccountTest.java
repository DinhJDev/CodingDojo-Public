public class BankAccountTest {
    public static void main (String args[]) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount();
        BankAccount a3 = new BankAccount();

        System.out.println(a1.accountNumber);
        a1.deposit(1000);
        a1.deposit(10000);
        a1.withdraw(5000);
        System.out.println(a1.getChkBal());
        System.out.println(a1.getSavBal());
        System.out.println(a1.getTotalBal());
        System.out.println(a1.accCreated);
    }
}
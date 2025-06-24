import java.util.ArrayList;

public class BankAccount {
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public BankAccount() {
        balance = 0;
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("✅ Deposited ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("✅ Withdrawn ₹" + amount);
            return true;
        } else {
            System.out.println("❌ Insufficient Balance!");
            return false;
        }
    }

    public boolean transfer(double amount, BankAccount receiver) {
        if (amount <= balance) {
            balance -= amount;
            receiver.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to", amount));
            return true;
        } else {
            System.out.println("❌ Transfer Failed: Insufficient Balance!");
            return false;
        }
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("🕒 No transactions found.");
        } else {
            System.out.println("📋 Transaction History:");
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}

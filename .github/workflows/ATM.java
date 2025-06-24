import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, User> users;
    private Scanner scanner;

    public ATM() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
        // Adding sample users
        users.put("user1", new User("user1", "1234"));
        users.put("user2", new User("user2", "5678"));
    }

    public void start() {
        System.out.println("🏦 Welcome to Java ATM");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        User currentUser = users.get(userId);
        if (currentUser != null && currentUser.validatePin(pin)) {
            System.out.println("✅ Login successful!");
            showMenu(currentUser);
        } else {
            System.out.println("❌ Invalid credentials!");
        }
    }

    private void showMenu(User user) {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.getAccount().printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = scanner.nextDouble();
                    user.getAccount().withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = scanner.nextDouble();
                    user.getAccount().deposit(depositAmt);
                    break;
                case 4:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter receiver User ID: ");
                    String receiverId = scanner.nextLine();
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmt = scanner.nextDouble();
                    User receiver = users.get(receiverId);
                    if (receiver != null) {
                        user.getAccount().transfer(transferAmt, receiver.getAccount());
                        System.out.println("✅ Transferred ₹" + transferAmt + " to " + receiverId);
                    } else {
                        System.out.println("❌ Receiver not found.");
                    }
                    break;
                case 5:
                    System.out.println("👋 Thank you for using Java ATM!");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);
    }
}

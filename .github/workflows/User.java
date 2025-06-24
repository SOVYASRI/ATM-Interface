public class User {
    private String userId;
    private String pin;
    private BankAccount account;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.account = new BankAccount();
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public BankAccount getAccount() {
        return account;
    }
}

public class User {

    private String name;
    private double balance;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {

        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public void showBalance() {

        System.out.println("--------------------------------");
        System.out.println("User : " + name);
        System.out.println("Balance : ₹" + balance);
        System.out.println("--------------------------------");
    }
}

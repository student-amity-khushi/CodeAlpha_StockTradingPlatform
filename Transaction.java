import java.util.ArrayList;

public class Transaction {

    private ArrayList<String> history = new ArrayList<>();

    public void addTransaction(String message) {

        history.add(message);
    }

    public void showHistory() {

        System.out.println("\n========== TRANSACTION HISTORY ==========");

        if (history.isEmpty()) {

            System.out.println("No Transactions Yet.");
            return;
        }

        for (String h : history) {

            System.out.println(h);
        }
    }
}

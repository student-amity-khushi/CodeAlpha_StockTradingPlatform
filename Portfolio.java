import java.util.HashMap;
import java.util.Map;

public class Portfolio {

    private HashMap<String, Integer> stocks = new HashMap<>();

    // Buy Stock
    public void buyStock(String stockName, int quantity) {

        if (stocks.containsKey(stockName)) {
            stocks.put(stockName, stocks.get(stockName) + quantity);
        } else {
            stocks.put(stockName, quantity);
        }

        System.out.println(quantity + " shares of " + stockName + " purchased successfully.");
    }

    // Sell Stock
    public boolean sellStock(String stockName, int quantity) {

        if (!stocks.containsKey(stockName)) {
            System.out.println("You don't own this stock.");
            return false;
        }

        int currentQty = stocks.get(stockName);

        if (quantity > currentQty) {
            System.out.println("Not enough shares.");
            return false;
        }

        if (quantity == currentQty) {
            stocks.remove(stockName);
        } else {
            stocks.put(stockName, currentQty - quantity);
        }

        System.out.println(quantity + " shares of " + stockName + " sold successfully.");
        return true;
    }

    // Display Portfolio
    public void displayPortfolio() {

        System.out.println("\n========== YOUR PORTFOLIO ==========");

        if (stocks.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }

        for (Map.Entry<String, Integer> entry : stocks.entrySet()) {

            System.out.println(
                    "Stock : " + entry.getKey()
                    + " | Quantity : " + entry.getValue());
        }
    }

    public int getQuantity(String stockName) {
        return stocks.getOrDefault(stockName, 0);
    }
}

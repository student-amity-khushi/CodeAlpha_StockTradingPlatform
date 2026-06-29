import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("     WELCOME TO STOCK TRADING PLATFORM");
        System.out.println("=======================================");

        System.out.print("Enter Your Name: ");
        String userName = sc.nextLine();

        User user = new User(userName, 100000);

        Portfolio portfolio = new Portfolio();
        Transaction transaction = new Transaction();

        ArrayList<Stock> market = new ArrayList<>();

        market.add(new Stock("TCS", 3500));
        market.add(new Stock("Infosys", 1600));
        market.add(new Stock("Reliance", 2900));
        market.add(new Stock("HDFC", 1700));
        market.add(new Stock("Wipro", 450));
        market.add(new Stock("Adani", 2500));

        int choice;

        do {

            System.out.println("\n============== MENU ==============");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n------ MARKET ------");

                    for (Stock s : market) {

                        System.out.println(
                                s.getStockName() +
                                "  ₹" +
                                s.getStockPrice());
                    }

                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.nextLine();

                    Stock selected = null;

                    for (Stock s : market) {

                        if (s.getStockName().equalsIgnoreCase(buyStock)) {

                            selected = s;
                            break;
                        }
                    }

                    if (selected == null) {

                        System.out.println("Stock Not Found.");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    double cost = qty * selected.getStockPrice();

                    if (user.withdraw(cost)) {

                        portfolio.buyStock(
                                selected.getStockName(),
                                qty);

                        transaction.addTransaction(
                                "Bought "
                                + qty
                                + " shares of "
                                + selected.getStockName()
                                + " for ₹"
                                + cost);

                        System.out.println("Purchase Successful.");

                    } else {

                        System.out.println("Insufficient Balance.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.nextLine();

                    Stock sell = null;

                    for (Stock s : market) {

                        if (s.getStockName().equalsIgnoreCase(sellStock)) {

                            sell = s;
                            break;
                        }
                    }

                    if (sell == null) {

                        System.out.println("Stock Not Found.");
                        break;
                    }

                    System.out.print("Enter Quantity: ");

                    int sellQty = sc.nextInt();

                    if (portfolio.sellStock(
                            sell.getStockName(),
                            sellQty)) {

                        double amount =
                                sellQty * sell.getStockPrice();

                        user.deposit(amount);

                        transaction.addTransaction(
                                "Sold "
                                + sellQty
                                + " shares of "
                                + sell.getStockName()
                                + " for ₹"
                                + amount);
                    }

                    break;

                case 4:

                    portfolio.displayPortfolio();

                    break;

                case 5:

                    user.showBalance();

                    break;

                case 6:

                    transaction.showHistory();

                    break;

                case 7:

                    System.out.println("\nThank You For Using Our Platform.");

                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}

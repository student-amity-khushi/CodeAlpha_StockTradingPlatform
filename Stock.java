public class Stock {

    private String stockName;
    private double stockPrice;

    public Stock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public String getStockName() {
        return stockName;
    }

    public double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {
        return stockName + "  ₹" + stockPrice;
    }
}

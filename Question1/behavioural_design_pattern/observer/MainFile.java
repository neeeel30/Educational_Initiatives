public class MainFile {
    public static void main(String[] args) {
        Stock googleStock = new Stock();

        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        googleStock.addObserver(investor1);
        googleStock.addObserver(investor2);

        googleStock.setPrice(1500.00f); // Investors get notified

        googleStock.setPrice(1550.00f); // Investors get notified again
    }
}

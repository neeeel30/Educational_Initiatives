import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Observer> investors = new ArrayList<>();
    private float price;

    public void addObserver(Observer investor) {
        investors.add(investor);
    }

    public void removeObserver(Observer investor) {
        investors.remove(investor);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer investor : investors) {
            investor.update(price);
        }
    }
}

package Stock;

import Subscriber.Subscriber;
import java.io.PrintWriter;

public interface IStock {
    public void notifyPrice(PrintWriter out);
    public void notifyCount(PrintWriter out);
    public void addSubscriber(Subscriber s);
    public void removeSubscriber(Subscriber s);
    public void increaseStock(float price, PrintWriter out);
    public void decreaseStock(float price, PrintWriter out);
    public void changeCount(int count, PrintWriter out);
}

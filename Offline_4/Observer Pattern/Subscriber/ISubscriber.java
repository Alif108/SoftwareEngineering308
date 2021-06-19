package Subscriber;

import Stock.Stock;
import java.io.PrintWriter;

public abstract class ISubscriber {
    public abstract void updatePrice(String name, float newPrice, PrintWriter out);
    public abstract void updateCount(String name, int newCount, PrintWriter out);
}

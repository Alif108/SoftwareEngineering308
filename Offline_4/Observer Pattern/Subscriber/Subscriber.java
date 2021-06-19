package Subscriber;

import Stock.Stock;
import java.io.PrintWriter;
import java.io.Serializable;

public class Subscriber extends ISubscriber implements Serializable{
    
    @Override
    public void updatePrice(String name, float newPrice, PrintWriter out) {
//        System.out.println("Price Changed for stock " + name + "\nNew Price : " + newPrice);
//        return "Price Changed for stock " + name + "\nNew Price : " + newPrice;
        out.println("Price Changed for stock " + name + "\nNew Price : " + newPrice);
    }
    
    public void updateCount(String name, int newCount, PrintWriter out){
//        System.out.println("Count Changed for stock " + name + "\nNew Count : " + newCount);
//        return "Count Changed for stock " + name + "\nNew Count : " + newCount;
        out.println("Count Changed for stock " + name + "\nNew Count : " + newCount);
    }
}

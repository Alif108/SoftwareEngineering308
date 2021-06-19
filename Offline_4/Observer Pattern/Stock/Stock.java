package Stock;

import Subscriber.Subscriber;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Stock implements IStock, Serializable{
    
    private ArrayList<Subscriber> subscribers;
    private float price;
    private int count;
    private String name;
    
    public Stock(String name, int count, float price)
    {
        this.name = name;
        this.count = count;
        this.price = price;
        subscribers = new ArrayList<Subscriber>();
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getSize()
    {
        return subscribers.size();
    }
 
    @Override
    public void increaseStock(float price, PrintWriter out) 
    {
        if(price < this.price)
            System.out.println("Please increase the Price");
        else
        {
            this.price = price;
            notifyPrice(out);
        }
    }

    @Override
    public void decreaseStock(float price, PrintWriter out) 
    {
        if(price > this.price)
            System.out.println("Please decrease the Price");
        else
        {
            this.price = price;
            notifyPrice(out);
        }
    }

    @Override
    public void changeCount(int count, PrintWriter out) 
    {
        if(count < 0)
        {
            System.out.println("Count cannot be negative");
            return;
        }
        this.count = count;
        notifyCount(out);
    } 

    @Override
    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
        System.out.println("Successful Subscription to " + getName());
    }

    @Override
    public void removeSubscriber(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void notifyPrice(PrintWriter out) {
        for(Subscriber sub : subscribers)
            sub.updatePrice(name, price, out);
    }

    @Override
    public void notifyCount(PrintWriter out) {
        for(Subscriber sub : subscribers)
            sub.updateCount(name, count, out);
    }
}

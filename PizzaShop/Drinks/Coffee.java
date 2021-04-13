package Drinks;


public class Coffee implements Drinks{

    @Override
    public String getFood() 
    {
        return "Coffee";
    }

    @Override
    public float getPrice() 
    {
        return (float)50.00;
    }
}
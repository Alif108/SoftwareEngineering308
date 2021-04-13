package Drinks;

public class Coke implements Drinks{

    @Override
    public String getFood() 
    {
        return "Coke";
    }

    @Override
    public float getPrice() 
    {
        return (float)20.00;
    }
}

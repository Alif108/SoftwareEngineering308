package Appetizer;


public class FrenchFry implements Appetizer{

    @Override
    public String getFood() 
    {
        return "French Fries";
    }

    @Override
    public float getPrice() 
    {
        return (float)50.00;
    }  
}

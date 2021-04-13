package FoodDecorator;

import Appetizer.Appetizer;
import Appetizer.OnionRing;
import Food.Food;

public class VeggiOnion extends FoodDecorator
{
    Appetizer onion_ring;
    
    public VeggiOnion(Food food)
    {
        super(food);
        onion_ring= new OnionRing();
    }

    @Override
    public String getFood() 
    {
        return decoratedFood.getFood() + " with " + onion_ring.getFood();
    }

    @Override
    public float getPrice() {
        return decoratedFood.getPrice() + onion_ring.getPrice();
    }
}

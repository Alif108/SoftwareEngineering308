package FoodDecorator;

import Appetizer.Appetizer;
import Appetizer.OnionRing;
import Drinks.Coffee;
import Drinks.Drinks;
import Food.Food;

public class Combo2 extends FoodDecorator
{
    Drinks coffee;
    Appetizer onion_ring;
    
    public Combo2(Food food) {
        super(food);
        coffee = new Coffee();
        onion_ring = new OnionRing();
    }
    
    @Override
    public String getFood()
    {
        return decoratedFood.getFood() + " with " + onion_ring.getFood() + " and " + coffee.getFood();
    }
    
    @Override
    public float getPrice()
    {
        return decoratedFood.getPrice() + onion_ring.getPrice() + coffee.getPrice();
    }
}

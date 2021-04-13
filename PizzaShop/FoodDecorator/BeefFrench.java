package FoodDecorator;

import Appetizer.Appetizer;
import Appetizer.FrenchFry;
import Food.Food;

public class BeefFrench extends FoodDecorator
{
    Appetizer french_fry;
    
    public BeefFrench(Food food)
    {
        super(food);
        french_fry = new FrenchFry();
    }

    @Override
    public String getFood() 
    {
        return decoratedFood.getFood() + " with " + french_fry.getFood();
    }

    @Override
    public float getPrice() {
        return decoratedFood.getPrice() + french_fry.getPrice();
    }
    
}

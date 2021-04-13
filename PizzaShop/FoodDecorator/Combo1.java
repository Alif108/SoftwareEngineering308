package FoodDecorator;

import Appetizer.Appetizer;
import Appetizer.FrenchFry;
import Drinks.Coke;
import Drinks.Drinks;
import Food.Food;

public class Combo1 extends FoodDecorator
{
    Drinks coke;
    Appetizer french_fry;
    
    public Combo1(Food food) {
        super(food);
        coke = new Coke();
        french_fry = new FrenchFry();
    }
    
    @Override
    public String getFood()
    {
        return decoratedFood.getFood() + " with " + french_fry.getFood() + " and " + coke.getFood();
    }
    
    @Override
    public float getPrice()
    {
        return decoratedFood.getPrice() + french_fry.getPrice() + coke.getPrice();
    }
}

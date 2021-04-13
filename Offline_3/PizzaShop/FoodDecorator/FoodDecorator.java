package FoodDecorator;

import Food.Food;

public abstract class FoodDecorator implements Food
{
    protected Food decoratedFood;
    
    public FoodDecorator(Food food)
    {
        this.decoratedFood = food;
    }
    
   @Override
   public String getFood()
   {
       return decoratedFood.getFood();
   }
   
   @Override
   public float getPrice()
   {
       return decoratedFood.getPrice();
   }
}

package pizzashop;

import Food.Food;
import FoodDecorator.*;
import Pizza.BeefPizza;
import Pizza.VeggiPizza;
import java.util.Scanner;


public class PizzaShop {

    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        Scanner s = new Scanner(System.in);
        Food pizza = null;
        Food order = null;
        
        System.out.println("Select Pizza: ");
        System.out.println("1. Beef Pizza");
        System.out.println("2. Veggi Pizza");
        
        choice = s.nextInt();
        
        if(choice == 1)
            pizza = new BeefPizza();
        else
            pizza = new VeggiPizza();
        
        System.out.println("Select Toppings: ");
        System.out.println("1. Pizza with French Fry");
        System.out.println("2. Pizza with onion rings");
        System.out.println("3. Combo meal 1 (Pizza, French Fry and Coke)");
        System.out.println("4. Combo meal 2 (Pizza, Onion Rings and Coffee)");
        System.out.println("5. Pizza only");
        
        choice = s.nextInt();
        
        if(choice == 1)
        {
            order = new BeefFrench(pizza);
        }
        else if(choice == 2)
        {
            order = new VeggiOnion(pizza);
        }
        else if(choice == 3)
        {
            order = new Combo1(pizza);
        }
        else if(choice == 4)
        {
            order = new Combo2(pizza);
        }
        else if(choice == 5)
        {
            order = pizza;
        }
        else
        {
            System.out.println("Choice does not exist");
        }
        
        if(order != null)
        {
            System.out.println(order.getFood());
            System.out.println("Price: " + order.getPrice());
        }
        else
            System.out.println("Order isn't constructed");
    }
}

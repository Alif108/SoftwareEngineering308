package Pizza;


public class VeggiPizza implements Pizza{

    @Override
    public String getFood() {
        return "Veggi Pizza";
    }

    @Override
    public float getPrice() {
        return (float) 100.00;
    }
}

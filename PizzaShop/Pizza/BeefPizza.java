package Pizza;

public class BeefPizza implements Pizza{

    @Override
    public String getFood() {
        return "Beef Pizza";
    }

    @Override
    public float getPrice() {
        return (float) 200.00;
    }
}

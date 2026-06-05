public abstract class PizzaDecorator implements Pizza{

    protected final Pizza pizza;

    PizzaDecorator(Pizza pizza)
    {
        this.pizza=pizza;
    }

}

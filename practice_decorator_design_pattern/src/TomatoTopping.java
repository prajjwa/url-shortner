public class TomatoTopping extends PizzaDecorator{




    public TomatoTopping(Pizza pizza)
    {

        super(pizza);

        System.out.println("Tomato topping added");


    }



    @Override
    public int calculatePrice() {
        return 20+pizza.calculatePrice();
    }
}

public class OnionTopping extends PizzaDecorator{



    public OnionTopping(Pizza pizza)
    {
        super(pizza);
        System.out.println("Onion topping added");
    }


    @Override
    public int calculatePrice() {
        return pizza.calculatePrice()+30;
    }
}

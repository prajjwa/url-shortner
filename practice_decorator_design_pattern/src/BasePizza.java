public class BasePizza implements Pizza{


    public BasePizza(){

        System.out.println("Base pizza");

    }


    @Override
    public int calculatePrice() {
        return 10;
    }
}

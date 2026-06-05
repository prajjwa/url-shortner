public class InsertCash extends AbstractState{


    public InsertCash(State state) {
        super(state);
    }

    @Override
    public void dispenseCashAndItem() {
        System.out.println("Cannot dispense in insert card");
    }


    @Override
    public void insertCash() {

        System.out.println("Card inserted");

         setState(new SelectItem());

    }

    @Override
    public void selectItem() {

        System.out.println("Cannot select item now");
    }
}

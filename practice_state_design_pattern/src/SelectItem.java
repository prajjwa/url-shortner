public class SelectItem extends AbstractState{


    public SelectItem(State state) {
        super(state);
    }

    @Override
    public void dispenseCashAndItem() {
        System.out.println("Cannot dispense cash in select item state");
    }


    @Override
    public void insertCash() {
        System.out.println("Cannot insert cash");
    }

    @Override
    public void selectItem() {

        System.out.println("Item selected");

        state.set


    }
}

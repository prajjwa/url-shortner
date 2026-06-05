public class DispenseItemAndCash extends AbstractState{


    public DispenseItemAndCash(State state) {
        super(state);
    }

    @Override
    public void dispenseCashAndItem() {

        System.out.println("Cash and Item dispensed");
    }

    @Override
    public void insertCash() {
        System.out.println("Cannot insert cash now");
    }

    @Override
    public void selectItem() {
        System.out.println("Cannot insert item now");
    }
}

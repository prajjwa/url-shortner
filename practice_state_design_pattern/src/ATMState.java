public class ATMState implements State{

    private State state;

    public ATMState(State state)
    {
        this.state=;
    }


    public void setState(State state) {
        this.state=state;
    }

    @Override
    public void dispenseCashAndItem() {
         state.dispenseCashAndItem();
    }

    @Override
    public void insertCash() {

        state.insertCash();
    }

    @Override
    public void selectItem() {

        state.selectItem();
    }
}

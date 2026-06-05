package atm.states;

import atm.AtmMachine;

public class InsertCardState implements ATMState {
    private AtmMachine atm;

    public InsertCardState(AtmMachine atm) {
        this.atm = atm;
    }

    @Override
    public boolean insertCard() {
        System.out.println("Card inserted successfully.");
        atm.setState(new EnterPinState(atm));
        return true;
    }

    @Override
    public boolean enterPin(String pinCode) {
        System.out.println("Cannot enter PIN without inserting card first.");
        return false;
    }

    @Override
    public Integer dispenseCash() {
        System.out.println("Cannot dispense cash without completing authentication.");
        return 0;
    }
}

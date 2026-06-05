package atm.states;

import atm.AtmMachine;

public class DispenseState implements ATMState {
    private AtmMachine atm;

    public DispenseState(AtmMachine atm) {
        this.atm = atm;
    }

    @Override
    public boolean insertCard() {
        System.out.println("Transaction in progress.");
        return false;
    }

    @Override
    public boolean enterPin(String pinCode) {
        System.out.println("PIN already entered.");
        return false;
    }

    @Override
    public Integer dispenseCash() {
        int amount = 100;
        System.out.println("Dispensing $" + amount + ". Transaction complete.");
        atm.setState(new InsertCardState(atm));
        return amount;
    }
}

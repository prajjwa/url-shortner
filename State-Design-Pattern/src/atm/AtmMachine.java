package atm;

import atm.states.ATMState;
import atm.states.InsertCardState;

public class AtmMachine {

    private ATMState currentState;

    public AtmMachine() {
        // Initialize with InsertCardState
        this.currentState = new InsertCardState(this);
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public boolean insertCard() {
        System.out.println("Attempting to insert card...");
        return currentState.insertCard();
    }

    public boolean enterPin(String pinCode) {
        System.out.println("Attempting to enter PIN...");
        return currentState.enterPin(pinCode);
    }

    public Integer dispenseCash() {
        System.out.println("Attempting to dispense cash...");
        return currentState.dispenseCash();
    }
}

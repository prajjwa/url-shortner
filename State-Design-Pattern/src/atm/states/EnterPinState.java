package atm.states;

import atm.AtmMachine;

public class EnterPinState implements ATMState {
    private AtmMachine atm;

    public EnterPinState(AtmMachine atm) {
        this.atm = atm;
    }

    @Override
    public boolean insertCard() {
        System.out.println("Card already inserted.");
        return false;
    }

    @Override
    public boolean enterPin(String pinCode) {
        if ("1234".equals(pinCode)) {
            System.out.println("PIN correct. Proceeding to dispense cash.");
            atm.setState(new DispenseState(atm));
            return true;
        } else {
            System.out.println("Incorrect PIN.");
            return false;
        }
    }

    @Override
    public Integer dispenseCash() {
        System.out.println("Cannot dispense cash without entering correct PIN.");
        return 0;
    }
}

package atm.states;

public interface ATMState {

    boolean insertCard();
    boolean enterPin(String pinCode);
    Integer dispenseCash();
}

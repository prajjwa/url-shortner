package atm;

import atm.AtmMachine;

public class Main {
    public static void main(String[] args) {
        AtmMachine atm = new AtmMachine();

        // Simulate ATM operations
        System.out.println("=== Starting ATM Simulation ===");

        // Try to enter PIN without card (should fail)
        atm.enterPin("1234");

        // Insert card
        atm.insertCard();

        // Enter wrong PIN
        atm.enterPin("0000");

        // Enter correct PIN
        atm.enterPin("1234");

        // Dispense cash
        atm.dispenseCash();

        // Try to dispense again (should fail, back to insert card)
        atm.dispenseCash();
    }
}

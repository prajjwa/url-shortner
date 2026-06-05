package commands;

public class InputCommand implements CommandInterface{
    @Override
    public boolean matches(String input) {
        return input.startsWith("INPUT");
    }

    @Override
    public void execute(String input) {



    }
}

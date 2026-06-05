package commands;

public class WriteCommand implements CommandInterface{

    @Override
    public boolean matches(String input) {
        return input.startsWith("WRITE");
    }

    @Override
    public void execute(String input) {



    }
}

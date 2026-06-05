package commands;

public interface CommandInterface {

    boolean matches(String input);
        void execute(String input);
}

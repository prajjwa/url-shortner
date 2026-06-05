public abstract class AbstractState implements State{


    protected  State state;

    public AbstractState(State state)
    {
        this.state=state;
    }

}

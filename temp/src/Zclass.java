import java.util.concurrent.Callable;

public class Zclass implements Callable<Integer> {

    private int num;

    public Zclass(int num)
    {
        this.num=num;
    }


    @Override
    public Integer call() throws Exception {

        Thread.sleep(2000);
        return num-10;
    }
}

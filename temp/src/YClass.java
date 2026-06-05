import java.util.concurrent.Callable;

public class YClass implements Callable<Integer> {

    private int num;
    public YClass(int num)
    {
        this.num=num;
    }



    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return num*10;
    }
}

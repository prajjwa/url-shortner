import java.util.concurrent.locks.ReentrantLock;

public class InventoryCounter {

    private ReentrantLock reentrantLock=new ReentrantLock();

    int count;

    public InventoryCounter()
    {
        count=0;
    }

    public void incrementCount()
    {
        reentrantLock.lock();

        count++;

        reentrantLock.unlock();


    }
}

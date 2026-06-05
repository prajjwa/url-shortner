import java.util.concurrent.Semaphore;

public class ThreadOdd implements Runnable{

    private Semaphore semaphore;

    private SharedData data;

    public ThreadOdd(Semaphore semaphore,SharedData data) {

        this.semaphore=semaphore;
        this.data=data;
    }

    @Override
    public void run() {

        while(true) {

            if (data.getNumber() % 2 == 1) {


                try {

                    semaphore.acquire();

                    System.out.println(data.getNumber() + " " + Thread.currentThread().getName());

                    data.setNumber(data.getNumber() + 1);

                    if (data.getNumber() > 10)
                        return;


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                }

            }

        }

    }
}

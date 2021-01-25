package thread;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SyncTest {

    protected volatile int value;

    private  int increment() {
//        System.out.println(Thread.currentThread().getName() +" -> call +++ ");
        return ++value;
    }


    public static void main(String[] args) {
        SyncTest data = new SyncTest();

        new Thread(() -> {
            int i = 0;
            while (i++ < 10) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A + value to " + data.increment());
            }
        }).start();

        new Thread(() -> {
            IntStream.range(1, 10).forEach(i -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B + value to  " + data.increment());
            });

        }).start();

    }
}

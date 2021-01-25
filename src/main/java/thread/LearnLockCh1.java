package thread;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Review how the lock works and how to use lock
 *
 * @author Rod
 * @date 2020/8/2
 */
public class LearnLockCh1 {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread a = new Thread(() -> {
            synchronized (lock) {
                IntStream.range(0, 20).forEach(i -> {
                    System.out.printf("I'm thread a, i am count number for %s \n", i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
        Thread b = new Thread(() -> {
            synchronized (lock) {
                IntStream.range(0, 20).forEach(i -> {
                    System.out.printf("I'm thread b, i am count number for %s \n", i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

            }
        });
        a.start();
        TimeUnit.MILLISECONDS.sleep(200);
        b.start();
    }
}


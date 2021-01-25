package c1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rod on 12/18/2017.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("haha");
        Runnable r1 = () -> System.out.println("R2 running");
        //thread run now
        ExecutorService hah = Executors.newCachedThreadPool();
        hah.submit(r);
        hah.shutdown();

        //thread run after 6 seconds
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleWithFixedDelay(r1, 6000, 2000, TimeUnit.MILLISECONDS);
        //ses.shutdown();

       /* ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(1);
        ses2.scheduleAtFixedRate(r1,6000,2,TimeUnit.MILLISECONDS);*/

    }
}

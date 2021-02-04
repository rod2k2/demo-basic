package thread;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static  boolean stopFlag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            int count = 0;
            while (!stopFlag) {
                count++;
            }
            System.out.printf("thread stop after %d \n",count);
        });
        t.start();

        TimeUnit.SECONDS.sleep(1);
        stopFlag = true;

    }
}

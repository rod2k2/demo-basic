package thread;

import java.util.concurrent.TimeUnit;

public class HowToJoin {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am A, i have done my job.");
        });

        Thread t2 = new Thread(()->{
            System.out.println("I am B, i have done my job.");
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();




    }
}

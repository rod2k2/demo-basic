package thread;

import java.util.concurrent.TimeUnit;

public class ThreadJoinTest {
    private int count;

    public static void main(String[] args) throws InterruptedException {
        ThreadJoinTest data = new ThreadJoinTest();
        Thread t1 = new Thread(()->{
            System.out.println("I'm thread I, i start running now ");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println("I'm thread II, i start running now ");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("I'm thread main, i'm going to close!");


    }

}


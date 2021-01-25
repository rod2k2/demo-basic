package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rod
 * @date 2020/7/27
 */
public class CountDownLatchTest {

    public static void main(String[] args) {

        CountDownLatchTest test = new CountDownLatchTest();
        test.doIt();
    }


    private void doIt(){
        //initialize countdown latch to 3 , after each thread completed it will decrease the number and main process will execute when countdownlatch is available
        final CountDownLatch cdl = new CountDownLatch(3);
        final AtomicInteger counter = new AtomicInteger();
        List<Thread> list = new ArrayList();
        for(  int i=0;i<3;i++){
            list.add( new Thread(()->{
                System.out.println("I'm thread ["+counter.addAndGet(1)+"] i am running");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
            }));
        }

        for (Thread t : list){
            t.start();
        }

        try {
            cdl.await();
            System.out.println("I'm thread MAIN, i am going to close only after all other thread completed !");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

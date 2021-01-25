package thread;

import java.util.concurrent.*;

/**
 * @author Rod
 * @date 2020/8/2
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> t1 = new FutureTask(()->{
           TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName());
            return "abc";
        });

        FutureTask<String> t2 = new FutureTask(()->{
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName());
            return "efg";
        });

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(t1);
        executor.submit(t2);
        while(true){
            if(t1.isDone()&&t2.isDone()){
                executor.shutdown();
                return;
            }

        }

    }
}

package thread;

import java.util.concurrent.*;

public class MyThreadTest1 {
    private static Boolean stop = false;
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        MyThreadTest1 my = new MyThreadTest1();

        FutureTask task = new FutureTask(my.initCallable());
        new Thread((task)).start();
        my.initThread().start();
        Object o = null;
        try {
            o = task.get(3,TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("can not get task completed");
            task.cancel(true);
        }
        System.out.println("result o is :"+o);

    }


    private   Thread initThread(){
        Thread t = new Thread(()->{
            int i=0;
            int max = 10;
            while(i<=max){
                i++;
                System.out.println(Thread.currentThread().getName()+"I am running here");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"i is ->"+i);
        });
        return t;
    }

    private  Callable<Integer> initCallable(){
        Callable c = () -> {
           int i = 0;
           int max = 10;
           while(i<=max){
               System.out.println(Thread.currentThread().getName()+"i am running here");
               i++;
               TimeUnit.SECONDS.sleep(1);
           }
           return i;
        };
        return c;
    }
}

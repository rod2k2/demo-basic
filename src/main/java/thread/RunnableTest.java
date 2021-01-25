package thread;

/**
 * @author Rod
 * @date 2020/8/2
 */
public class RunnableTest {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am running man!");
            }
        };

        Thread t = new Thread(r);
        t.start();
//        t.start();//you will get exception here if call start method multiple times
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Rod
 * @date 2021/1/8
 */
@Slf4j
public class RedisKeyTest {
    protected Jedis jedis = new Jedis("localhost", 6379);

    public static final String COUNTER = "counter:example";
    ExecutorService threadPool = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {

        RedisKeyTest t1 = new RedisKeyTest();
        RedisKeyTest t2 = new RedisKeyTest();
        RedisKeyTest t3 = new RedisKeyTest();
//        test.trySimpleKey();
        log.debug("start my test");
        t1.threadPool.execute(() -> {
            for (int x = 0; x < 10; x++) {
                Random r = new Random(100);
                log.debug("try incr with return value {}", t1.jedis.incrBy(COUNTER,r.nextInt(100)));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.threadPool.execute(() -> {
            for (int x = 0; x < 10; x++) {
                Random r = new Random(50);
                log.debug("try decr with return value {}", t2.jedis.decrBy(COUNTER,r.nextInt(100)));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t3.threadPool.execute(() -> {
            for (int x = 0; x < 10; x++) {
                log.debug("here is counter value: {}", t3.jedis.get(COUNTER));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @PostConstruct
    public void init() {
    }

    private void trySimpleKey() {
        jedis.setex("key1", 10, "hello");
        threadPool.submit(() -> {
            while (true) {
                String value = jedis.get("key1");
                if (value == null) {
                    break;
                } else {
                    log.debug("Get data value is " + value);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        log.error(e.getMessage(), e.getCause());
                    }
                }
            }
        });
        threadPool.submit(() -> {
            jedis.setex("key1", 3, "what is it ");
        });
    }


}

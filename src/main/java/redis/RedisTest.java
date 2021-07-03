package redis;

import redis.clients.jedis.Jedis;

/**
 * @author Rod
 * @date 2021/1/8
 */
public class RedisTest {

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("localhost",6379);
        jedis.setex("key1",10,"hello");
        while(true){
            String value = jedis.get("key1");
            if (value == null){
                break;
            }else{
                System.out.println("Get data value is "+ value);
                Thread.sleep(1000);
            }
        }
        System.out.println("end with fetch data ");
    }
}

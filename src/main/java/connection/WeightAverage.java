package connection;

import java.util.HashMap;
import java.util.Map;

/**
 * test weighted average
 * <p>
 * 10 qty under $20.
 * 20 qty under $30.
 * <p>
 * average = 20+30 / 30
 * weighted average  = （10*20+20*30） / （10+20）
 *
 * @author Rod ,have fun with coding
 * @date 2021/2/4 7:26
 */
public class WeightAverage {


    public static void main(String[] args) {

        Map<Integer,Integer> m = new HashMap<>();
        m.put(10,20);
        m.put(20,30);

        int sumProduct = m.entrySet().stream().mapToInt(x -> x.getKey() * x.getValue()).sum();
        int sum = m.keySet().stream().reduce(Integer::sum).get().intValue();
        System.out.println(sumProduct/sum);
    }
}

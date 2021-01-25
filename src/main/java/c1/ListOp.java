package c1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rod on 12/18/2017.
 */
public class ListOp {
    public static Integer LIST_SIZE = 1000;

    public static void main(String[] args) {
        List<Integer> integers = initList();

        Integer maxValue = integers.parallelStream().reduce(Math::max).get();
        Integer minValue = integers.parallelStream().reduce(Math::min).get();
        BigDecimal avgValue = BigDecimal.valueOf((maxValue + minValue) / 2.0);
        System.out.printf("max value is :%05d and min value is :%05d and the average is :" +
                "%5.4f", maxValue, minValue, avgValue);
    }

    public static List<Integer> initList() {
        List<Integer> integers = new ArrayList<>();
        int i = 1;
        while (i <= 1000) {
            integers.add(i++);
        }
        return integers;
    }
}

package stream;

import java.util.stream.IntStream;


/**
 * @author Rod
 * @date 2020/8/12
 */
public class Ex1 {

    public static void main(String[] args) {

        /**
         * Stream 惰性求值和及早求值
         */

        IntStream.range(0,10).filter(x-> (x%2)>0).forEach(x -> System.out.printf("val : %d \n",x));

        System.out.printf("Maximum value is %d \n",IntStream.of(1,3,10,99999,-123,123).max().orElse(-1)); //max() return optional
        System.out.printf("Sum value is %d \n",Ex1.sum(1,2,3,4,5,6));

        System.out.printf("reduce stream as one value %d \n",IntStream.of(1,2,3).reduce((x,y)->x*y).getAsInt());

        System.out.printf("map stream as a new stream %s \n",IntStream.of(1,2,3).mapToObj(x->"A"+x));

    }




    public static int sum(int ... values){
        return IntStream.of(values).sum();
    }
}

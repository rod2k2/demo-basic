package c1;



import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * @author Rod
 * @date 2020/6/23
 */
public class ArrayTest {

    /**
     * @param nums , arrays need process
     * @return the length of nums not contains duplicated value
     */
    private int[] removeDuplicated(int[] nums) {

        HashSet<Integer> s = new HashSet();
        for(int x : nums){
            s.add(x);
        }
        return s.stream().mapToInt(Integer::intValue).toArray();  //it take 78 ms

        /*
        //below just take 1ms
        int[] arr = new int[s.size()];
        int index = 0;
        for( Integer i : s ) {
            arr[index++] = i; //note the auto unboxing here
        }
        return arr;
        */
    }

    public static void main(String[] args) {
        ArrayTest at = new ArrayTest();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6};
        StopWatch started = StopWatch.createStarted();
        int[] newNums  = at.removeDuplicated(nums);
        System.out.println("it take ...."+started.getTime(TimeUnit.MILLISECONDS));
        for(int x : newNums){
            System.out.println(x);
        }
    }
}

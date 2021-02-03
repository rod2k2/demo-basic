package learn.sort;

import java.util.Arrays;

/**
 * @author Rod ,have fun with coding
 * @date 2021/2/3 13:06
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums =new int[]{1,9,8,13,7,11};
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int left = nums[i];
                int right = nums[j];
                if( left > right){
                    nums[i] = right;
                    nums[j] = left;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

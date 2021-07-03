package problem.threesum;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        System.out.println("received array is "+ToStringBuilder.reflectionToString(nums,ToStringStyle.SIMPLE_STYLE));
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length<2){
            return result;
        }
        Arrays.sort(nums);
        System.out.println(" after sort , array become as "+ToStringBuilder.reflectionToString(nums,ToStringStyle.SIMPLE_STYLE));

        //双指针
        for( int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break; //Why -3 + 1 + 2 = 0;
            }
            if(i > 0 && nums[i] == nums[i-1] ){
                continue; // remove duplicate
            }
            int L = i+1;
            int R = nums.length-1;

            while(L < R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L < R && nums[L] == nums[L+1]){
                        L++;
                    }
                    while(L<R && nums[R]== nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if (sum <0){
                    L++;
                }else if ( sum > 0 ){
                    R--;
                }
            }
        }

        return result;
    }
}

public class SolutionTest{

    @Test
    public void test(){
        Solution s  = new Solution();
        int[] testData = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = s.threeSum(testData);

        for (List<Integer> list : lists) {
            System.out.printf("result matrix is %s \n",list.toString());
        }
    }
}

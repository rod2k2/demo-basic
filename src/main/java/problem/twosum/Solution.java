package problem.twosum;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> rs = new ArrayList<>();

        for(int x =0;x <nums.length;x++){
            for ( int y =x+1; y< nums.length;y++)
                if (nums[x] + nums[y] == 0) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[x]);
                    sub.add(nums[y]);
                    rs.add(sub);
                }
        }

        return rs;
    }

    public static void main(String[] args) {

        int[] nums = {-2,-1, 0, 1, 2, 3, 4};
        Solution s = new Solution();

        List<List<Integer>> lists = s.threeSum(nums);
        System.out.println(lists);
        //each value sum is zero
        for(List<Integer> subList : lists){
            int total = subList.stream().reduce((x,y)->x+y).get();
            System.out.printf("result is %d \n ",total);
            if(total != 0){
                throw new RuntimeException("Wrong results");
            }
        }
    }
}

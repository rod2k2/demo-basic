package c1;

import org.junit.Assert;

/**
 * @author Rod
 * @date 2020/6/30
 */
public class PlusOne {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1,2,3};
        int[] b = solution.plusOne(a);
        Assert.assertEquals(b[2],4);
    }

}
class Solution {
    public int[] plusOne(int[] digits) {
        return digits;
    }
}

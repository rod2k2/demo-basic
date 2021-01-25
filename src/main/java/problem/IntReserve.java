package problem;

/**
 * @author Rod
 * @date 2020/7/15
 */
public class IntReserve {
    public static void main(String[] args) {
//        int a = 1234;
//        int b = 987654;
//        int c = 1230456;
//        int d = 10;
//        int e = -123456;
        int f = 1534236469;

        Solution solution = new Solution();
//        System.out.println(solution.reverse(a));
//        System.out.println(solution.reverse(b));
//        System.out.println(solution.reverse(c));
//        System.out.println(solution.reverse(d));
//        System.out.println(solution.reverse(e));
        System.out.println(solution.reverse(f));
    }

}

class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0 ){
            if( (res * 10 ) / 10 != res ){
                res = 0;
                break;
            }
            int tmp = x % 10;
            res = res * 10 + tmp;
            x = x/10;
        }
        return res;

    }
}

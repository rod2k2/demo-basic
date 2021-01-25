package problem.nqueue;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int i) {

        int[] rows = new int[i];
        Arrays.fill(rows,1);
        int[] cols = new int[i];
        Arrays.fill(cols,0);

        for(int r=0;r<i;r++){
             for(int c=0;c<i;c++){
                System.out.print("x:->"+rows[r]+"->y:"+cols[c]);
            }
            System.out.println();
        }

        return null;
    }
}

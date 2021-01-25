package sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {

    public static int[] sort(int[] array,boolean debug){
        /**
         * 双层遍历,
         * 1. 选择第一个元素后,比较数组中其他元素
         * 2. 继续选择元素
         *
         * 算法速度: ~ O(n2)
         */
        int loopsize=1;
        for(int x = 0; x< array.length;x++){
            loopsize++;
            for( int y=x+1;y< array.length;y++){
                int tmp = array[x];
                loopsize++;
                if(array[x]>array[y]){
                    array[x] = array[y];
                    array[y] = tmp;
                }
            }
        }
        if(debug){
            System.out.println("数组长度为:"+array.length+"查询次数为:"+loopsize);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a1 ={1,3,2,4};
        System.out.println("Before:"+ Arrays.toString(a1));
        SelectSort.sort(a1,true);
        System.out.println("After:"+Arrays.toString(a1));

         int[] a2 ={1,3,2,4,5};
        System.out.println("Before:"+ Arrays.toString(a2));
         SelectSort.sort(a2,true);
        System.out.println("After:"+Arrays.toString(a2));

        Random r = new Random();
        int[] inits = r.ints(50,-100,100).toArray();
        System.out.println("Before:"+ Arrays.toString(inits));
        SelectSort.sort(inits,true);
        System.out.println("After:"+Arrays.toString(inits));
    }
}

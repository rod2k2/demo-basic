package sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class InsertSort {

    public static void  sort(int[] arys){
        int N = arys.length;
        for (int i = 0; i <N ; i++) {
            for (int j = i; j>0 && arys[j-1] > arys[j] ; j--) {
                int tmp = arys[j-1];
                arys[j-1]=arys[j];
                arys[j]=tmp;
            }
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] arys = r.ints(1000*100,0,20).toArray();
        System.out.println(LocalDateTime.now().toString()+" Before:");
        InsertSort.sort(arys);
        System.out.println(LocalDateTime.now().toString()+" After:");


        System.out.println(LocalDateTime.now().toString()+" Before:");
        Arrays.sort(arys);
        System.out.println(LocalDateTime.now().toString()+" After:");

    }
}

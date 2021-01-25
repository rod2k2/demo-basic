package learn.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rod ,have fun with coding
 * @date 2021/1/23
 */
public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println("what is value of number  = " + getNumber());
        System.out.println("what is value of numbers  = " + getNumbers());
    }

    private static int getNumber(){
        int i =0;
        try{
            i++;
            int y = i/0;
            return ++i;
        }catch(Exception e ){
            i++;
        }finally {
            i++;
        }
        return i;
    }

    private static List<Integer> getNumbers(){
        List<Integer> list = new ArrayList<>();
        int x = 0;
        try{
           list.add(1);
           int y = 2/x;
           return list;
        }catch(Exception e ){
            list.add(2);
        }finally {
            list.add(3);
        }
        return list;
    }
}

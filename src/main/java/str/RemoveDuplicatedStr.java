package str;

import java.util.*;

/**
 * @author Rod
 * @date 2021/1/6
 */
public class RemoveDuplicatedStr {

    public static void main(String[] args) {

        String s = "Hello World";
        StringBuilder newWord = new StringBuilder();
        char[] chars = s.toCharArray();
        HashMap<String,Integer> m = new LinkedHashMap<>();
        for(char c : chars){
            Integer cnt = m.getOrDefault(String.valueOf(c), 0);
            m.put(String.valueOf(c),cnt.intValue()+1);
        }
        Iterator<Map.Entry<String, Integer>> iterator = m.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getValue()==1){
                newWord.append(next.getKey());
            }
        }
        System.out.println(newWord.toString());


        System.out.println("NEW".equals(new String("NEW")));
        System.out.println("NEW" == new String("NEW"));

    }
}

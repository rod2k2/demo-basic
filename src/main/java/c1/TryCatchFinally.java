package c1;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Rod
 * @date 2020/7/3
 */
public class TryCatchFinally {

    public static void main(String[] args) {

        System.out.println(testMethod());
        System.out.println(testMethod4Ref().toString());

    }

    public static int testMethod() {
        int x = 0;
        try {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static UserPojo  testMethod4Ref(){
        UserPojo user = new UserPojo();
        try{
            user.setUserId(123);
            user.setUserName("Rod");
            return user;
        }finally{
            user.setUserName("Rod Zhong");
        }
    }
}

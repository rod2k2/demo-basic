package c1;


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
        } finally {
            x = 3;
        }
        return x;
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

package learn.hash;

import model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rod ,have fun with coding
 * @date 2021/1/29 19:54
 */
public class LearnHash {
    public static void main(String[] args) {

        User user = new User();
        user.setAge(18);
        user.setId(1);
        System.out.println(user.hashCode());
        System.out.println(hash(user));
        System.out.println(5067115 ^ 5067115 >>> 16 );
        Map<User,User> m = new HashMap<>();
        m.put(user,user);

    }

    /**
     * below method copy from HashMap.hash();
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

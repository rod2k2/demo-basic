package connection;

import model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/**
 * know how to use Stream
 */
public class MyStream {

    private List<User> userList = new LinkedList<User>();

    public void init(){
        for(int x = 0 ; x <10000;x++){
            userList.add(User.builder().id(x).name("Mr."+x).age(new Random().nextInt(100)).build());
        }
    }

    public static void main(String[] args) {
        MyStream data = new MyStream();
        data.init();
        long count = data.userList.stream().filter(user -> user.getAge() > 95).count();
        System.out.printf("there are %d people over 90 years",count);


        Predicate<User> userFilter = user -> {
            if (user.getAge() > 95) {
                return true;
            } else {
                return false;
            }
        };
        //data.userList.stream().filter( userFilter).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----------------------------");
        User user = data.userList.stream().filter( userFilter).findFirst().orElse(null);
        Integer totalAge = data.userList.stream().map(User::getAge).reduce(Math::addExact).get();
        System.out.println(totalAge);
        System.out.println(user);
    }
}

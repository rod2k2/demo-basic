package c1;

/**
 * Created by Rod on 12/18/2017.
 */
public class Printf {
    public static void main(String[] args) {
        System.out.printf("Hello %s \n", "World");
        System.out.printf("this is a number %d \n", 1);
        System.out.printf("this is a number with five width %5d\n", 1);
        System.out.printf("this is a number with five width,from left %-5d\n", 1);
        System.out.printf("this is a number with five width,use 0 to fill %05d\n", 1);
        System.out.printf("this is a float value with 2 decimal,%.4f \n", 123.456789);
        System.out.printf("this is a float value with 4 decimal,%.4f \n", 123.456789);
        System.out.printf("this is a float value with default decimal,%f \n", 123.4567890123);

    }
}

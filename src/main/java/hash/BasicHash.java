package hash;

import sun.security.provider.MD5;

public class BasicHash {
    public static void main(String[] args) {
        String textContent ="This is a text message to show what will the value be after hashing";
        System.out.println(textContent.hashCode());

    }
}

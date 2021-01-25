package proxyexample;

import proxyexample.service.OrderService;
import proxyexample.service.OrderServiceImpl;
import proxyexample.service.UserService;
import proxyexample.service.UserServiceImpl;

public class ProxyTestClient {

    public static void main(String[] args) {
            case1();
            case2();
    }

    /**
     * user java proxy and InvocationHandler to append proxy pattern
     */
    public static void case1(){
        UserService userService = (UserService)new ServiceProxyInvocationHandler().bind(new UserServiceImpl());
        userService.addUser();
        OrderService orderService = (OrderService)new ServiceProxyInvocationHandler().bind(new OrderServiceImpl());
        orderService.addOrder();
    }

    /**
     * case 2 use cglib to do proxy
     */
    public static void case2(){
        UserService userService = (UserService)new ServiceProxyCglib().getInstance(new UserServiceImpl());
        OrderService orderService = (OrderService)new ServiceProxyCglib().getInstance(new OrderServiceImpl());
        userService.addUser();
        orderService.addOrder();
    }
}

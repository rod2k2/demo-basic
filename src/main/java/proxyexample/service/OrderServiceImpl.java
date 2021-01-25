package proxyexample.service;

public class OrderServiceImpl implements OrderService {
    @Override
    public String addOrder() {
        System.out.println("impl-> i am add order");
        return "Order{Id=123,amount=1000,00}";
    }
}

package rq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Receiver {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(Sender.QUEUE_NAME,false,false,false,null);
        System.out.println(" * wait message broker *");
        DeliverCallback callback = (consumeTag, delivery)->{
            String msg = new String(delivery.getBody(),"UTF-8");
            System.out.println("Received msg [x] ->"+msg);
        };
        channel.basicConsume(Sender.QUEUE_NAME,true,callback,consumeTag->{
            System.out.println("what is this ");
        });
    }

}

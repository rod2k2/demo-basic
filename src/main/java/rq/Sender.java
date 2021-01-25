package rq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {

    public static String QUEUE_NAME="rod-test";
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel();){
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String msg = "Hello,world";
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("[x],send message ok");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

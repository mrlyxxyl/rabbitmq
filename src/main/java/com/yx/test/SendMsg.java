package com.yx.test;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

/**发送队列消息
 * User: LiWenC
 * Date: 16-9-1
 */
public class SendMsg {
    //队列名称
    private final static String QUEUE_NAME = "queue_one";

    public static void main(String[] args) throws java.io.IOException, TimeoutException {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名
        factory.setHost("localhost");
        //创建一个连接
        Connection connection = factory.newConnection();
        //创建一个频道
        Channel channel = connection.createChannel();
        //指定一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //发送的消息
        String message = "hello world!";
        //往队列中发出一条消息
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭频道和连接
        channel.close();
        connection.close();
    }
}
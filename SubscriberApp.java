import com.rabbitmq.client.*;

import java.util.Scanner;

public class SubscriberApp {

    private static final String EXCHANGE_NAME = "blogExchanger";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в IT-blog!");
        System.out.print("Введите название языка программирования для подписки на его статьи: ");
        String key = scanner.nextLine().toLowerCase();

        channel.queueBind(queueName, EXCHANGE_NAME, key);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String article = new String(delivery.getBody(), "UTF-8");
            System.out.println("New article: \n" + article);
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

    }

}

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BlogApp {

    private static final String EXCHANGE_NAME = "blogExchanger";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try(Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            Scanner scanner = new Scanner(System.in);
            String key;
            System.out.println("Для завершения работы блога введите команду \"stop\"");
            do {
                System.out.println("Опубликуйте Вашу статью в формате \"<язык программирования> <статья>\":");
                key = scanner.next().toLowerCase();
                if (!key.equals("stop")) {
                    String article = scanner.nextLine();
                    channel.basicPublish(EXCHANGE_NAME, key, null, article.getBytes(StandardCharsets.UTF_8));
                }
            } while (!key.equals("stop"));

        }

    }

}

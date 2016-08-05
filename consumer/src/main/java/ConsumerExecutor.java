import javax.jms.JMSException;

/**
 * Created by damian on 05.08.16.
 */
public class ConsumerExecutor {
    public static void main(String... args){
        Consumer consumer = new Consumer();
        try {
            consumer.register();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

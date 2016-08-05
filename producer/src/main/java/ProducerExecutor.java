import javax.jms.JMSException;

/**
 * Created by damian on 05.08.16.
 */
public class ProducerExecutor {

    public static void main(String[] args){
        Producer producer = new Producer();
        try {
            producer.register();
            for (int i = 0; i < 20; i++) {
                producer.sendMessage("Wiadomosc, nr: "+(i+1));
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

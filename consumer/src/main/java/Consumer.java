import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.Connection;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import javax.jms.*;

import static java.lang.Thread.sleep;

/**
 * Created by damian on 05.08.16.
 */
public class Consumer implements MessageListener {

    public static Logger LOGGER = LoggerFactory.getLogger(Consumer.class) ;

    public static final String QUEUE_NAME = "damian.queue";

    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try {
                System.out.println(((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

        LOGGER.info("Wiadomosc dotarla!");
        LOGGER.error("Wiadomosc dotarla! : jako ERROR : TEST");
//        LOGGER.error();
//        MarkerFactory mf = new MarkerFactory();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void register() throws JMSException {

//        LOGGER

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        javax.jms.Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer(new ActiveMQQueue(QUEUE_NAME));

        consumer.setMessageListener(this);
        connection.start();
    }

}

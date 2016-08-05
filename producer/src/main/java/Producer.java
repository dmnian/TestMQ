import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;


/**
 * Created by damian on 05.08.16.
 */
public class Producer {

    public static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private Session session;
    private MessageProducer messageProducer;

    public void register() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = activeMQConnectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        messageProducer = session.createProducer(new ActiveMQQueue(Consumer.QUEUE_NAME));
    }

    public void sendMessage(String message) throws JMSException {
        TextMessage textMessage = session.createTextMessage(message);
        messageProducer.send(textMessage);

        LOGGER.info("Wiadomosc wyslana!");
    }
}

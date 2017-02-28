package training.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import training.spring.model.Message;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-23
 * Time: 20:50
 */
public class ExampleMessageService extends AbstractMessageService {

    private static final Logger log = LoggerFactory.getLogger(ExampleMessageService.class);

    @Override
    public void send(Message message) {
        getRestTemplate().postForLocation(URI.create(getUrl(message.getTo())), getFormUrlEntity(message));
        log.info("Message sent: " + message.toString());
    }

    @Override
    public void received(Message message) {
        log.info("Message received: " + message.toString());
    }
}

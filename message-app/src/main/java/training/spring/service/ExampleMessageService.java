package training.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;
import training.spring.model.Message;

import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-23
 * Time: 20:50
 */
public class ExampleMessageService implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(ExampleMessageService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void send(Message message) {
        String url = String.format("http://%s/receive", message.getTo());
        restTemplate.postForLocation(URI.create(url), Message.class);
        log.info("Message sent: " + message.toString());
    }

    @Override
    public void received(Message message) {
        log.info("Message received: " + message.toString());
    }
}

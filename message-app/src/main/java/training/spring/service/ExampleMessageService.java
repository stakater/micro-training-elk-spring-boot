package training.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import training.spring.model.Message;

import java.net.URI;
import java.util.Arrays;

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

        HttpEntity<MultiValueMap<String, String>> entity = getEntity(message);

        restTemplate.postForLocation(URI.create(url), entity);
        log.info("Message sent: " + message.toString());
    }

    @Override
    public void received(Message message) {
        log.info("Message received: " + message.toString());
    }

    private HttpEntity<MultiValueMap<String, String>> getEntity(Message message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("from", message.getFrom());
        map.add("to", message.getTo());
        map.add("message", message.getMessage());

        return new HttpEntity<>(map, headers);
    }
}

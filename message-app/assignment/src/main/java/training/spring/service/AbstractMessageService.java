package training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import training.spring.model.Message;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-26
 * Time: 12:35
 */
public abstract class AbstractMessageService implements MessageService {

    @Autowired
    private RestTemplate restTemplate;

    public String getUrl(String to) {
        return String.format("http://%s/receive", to);
    }

    public HttpEntity<MultiValueMap<String, String>> getFormUrlEntity(Message message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("from", message.getFrom());
        map.add("to", message.getTo());
        map.add("message", message.getMessage());

        return new HttpEntity<>(map, headers);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}

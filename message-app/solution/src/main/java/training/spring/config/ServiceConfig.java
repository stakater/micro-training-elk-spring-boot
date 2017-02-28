package training.spring.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import training.spring.service.ExampleMessageService;
import training.spring.service.MessageService;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-23
 * Time: 20:48
 */
public class ServiceConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MessageService messageService() {
        return new ExampleMessageService();
    }
}

package training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import training.spring.controller.ConsulController;
import training.spring.controller.MessageController;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-23
 * Time: 20:48
 */
@Configuration
public class WebConfig {

    @Bean
    public MessageController messageController() {
        return new MessageController();
    }

    @Bean
    public ConsulController consulController() {
        return new ConsulController();
    }
}

package training.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import training.spring.model.Message;
import training.spring.service.MessageService;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-23
 * Time: 20:49
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "send";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void sendMessage(Message message) {
        message.setFrom(applicationName);
        messageService.send(message);
    }

    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public void receiveMessage(Message message) {
        messageService.received(message);
    }
}

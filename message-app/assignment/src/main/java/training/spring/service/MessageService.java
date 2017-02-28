package training.spring.service;

import training.spring.model.Message;

/**
 * Created with IntelliJ IDEA.
 * User: markus
 * Date: 2017-02-23
 * Time: 20:50
 */
public interface MessageService {

    void send(Message message);

    void received(Message message);
}

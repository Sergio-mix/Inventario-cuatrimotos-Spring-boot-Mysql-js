package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Message;
import co.edu.usa.Reto3.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message create(Message quadBike) {
        return messageRepository.save(quadBike);
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message findById(Long id) {
        Optional<Message> message = Optional.of(messageRepository.getById(id));
        return message.orElse(new Message());
    }

}

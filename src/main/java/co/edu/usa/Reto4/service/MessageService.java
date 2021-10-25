package co.edu.usa.Reto4.service;

import co.edu.usa.Reto4.model.Message;
import co.edu.usa.Reto4.repositories.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message create(Message quadBike) {
        return messageRepository.create(quadBike);
    }

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Message findById(Long id) {
        return messageRepository.findById(id);
    }

    public void remove(Long id) {
        messageRepository.remove(id);
    }

    public void update(Message message) {
        messageRepository.update(message);
    }

}

package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Category;
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

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Message message : messageRepository.findAll()) {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("idMessage", message.getIdMessage());
            m.put("messageText", message.getMessageText());

            Map<String, Object> quadbike = new LinkedHashMap<>();
            quadbike.put("id", message.getQuadbike().getId());
            quadbike.put("name", message.getQuadbike().getName());
            quadbike.put("brand", message.getQuadbike().getBrand());
            quadbike.put("year", message.getQuadbike().getYear());
            quadbike.put("description", message.getQuadbike().getDescription());

            Map<String, Object> category = new LinkedHashMap<>();
            category.put("id", message.getQuadbike().getCategory().getId());
            category.put("name", message.getQuadbike().getCategory().getName());
            category.put("description", message.getQuadbike().getCategory().getDescription());

            quadbike.put("category", category);

            m.put("quadbike", quadbike);

            m.put("client", message.getClient());

            list.add(m);
        }

        return list;
    }

    public Message findById(Long id) {
        Optional<Message> message = Optional.of(messageRepository.getById(id));
        return message.orElse(new Message());
    }

}

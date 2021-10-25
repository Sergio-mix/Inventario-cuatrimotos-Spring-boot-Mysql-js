package co.edu.usa.Reto4.repositories;

import co.edu.usa.Reto4.model.Message;
import co.edu.usa.Reto4.repositories.jpa.MessageJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageJpaRepository messageJpaRepository;

    public Message create(Message quadBike) {
        return messageJpaRepository.save(quadBike);
    }

    public List<Message> getAll() {
        return messageJpaRepository.findAll();
    }

    public Message findById(Long id) {
        Optional<Message> message = Optional.of(messageJpaRepository.getById(id));
        return message.orElse(new Message());
    }

    public void remove(Long id) {
        messageJpaRepository.deleteById(id);
    }

    public void update(Message message){
        messageJpaRepository.saveAndFlush(message);
    }
}

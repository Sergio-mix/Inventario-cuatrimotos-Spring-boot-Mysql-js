package co.edu.usa.Reto3.repository;

import co.edu.usa.Reto3.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}

package co.edu.usa.reto4.repositories.jpa;

import co.edu.usa.reto4.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageJpaRepository extends JpaRepository<Message,Long> {
}

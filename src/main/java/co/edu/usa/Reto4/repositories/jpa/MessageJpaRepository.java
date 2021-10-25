package co.edu.usa.Reto4.repositories.jpa;

import co.edu.usa.Reto4.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageJpaRepository extends JpaRepository<Message,Long> {
}

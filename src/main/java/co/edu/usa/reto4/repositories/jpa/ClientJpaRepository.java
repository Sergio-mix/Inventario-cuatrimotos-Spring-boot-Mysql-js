package co.edu.usa.reto4.repositories.jpa;

import co.edu.usa.reto4.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientJpaRepository extends JpaRepository<Client,Long> {
}

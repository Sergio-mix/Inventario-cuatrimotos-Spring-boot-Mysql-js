package co.edu.usa.Reto4.repositories.jpa;

import co.edu.usa.Reto4.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientJpaRepository extends JpaRepository<Client,Long> {
}

package co.edu.usa.Reto3.repository;

import co.edu.usa.Reto3.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}

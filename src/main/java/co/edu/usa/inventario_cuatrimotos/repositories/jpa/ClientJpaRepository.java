package co.edu.usa.inventario_cuatrimotos.repositories.jpa;

import co.edu.usa.inventario_cuatrimotos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientJpaRepository extends JpaRepository<Client,Long> {
}

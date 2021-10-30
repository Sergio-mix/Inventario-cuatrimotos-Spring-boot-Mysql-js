package co.edu.usa.inventario_cuatrimotos.repositories.jpa;

import co.edu.usa.inventario_cuatrimotos.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageJpaRepository extends JpaRepository<Message,Long> {
}

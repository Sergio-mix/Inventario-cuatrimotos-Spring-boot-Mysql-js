package co.edu.usa.inventario_cuatrimotos.repositories.jpa;

import co.edu.usa.inventario_cuatrimotos.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminJpaRepository extends JpaRepository<Admin, Long> {


}

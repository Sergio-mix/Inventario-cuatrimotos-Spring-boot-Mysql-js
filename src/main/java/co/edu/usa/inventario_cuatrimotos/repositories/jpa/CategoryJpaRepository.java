package co.edu.usa.inventario_cuatrimotos.repositories.jpa;

import co.edu.usa.inventario_cuatrimotos.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {

}
